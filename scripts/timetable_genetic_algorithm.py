import random
import json
from datetime import datetime, timedelta
from typing import List, Dict, Tuple
import copy

class TimetableGeneticAlgorithm:
    def __init__(self):
        # University of Computer Science specific data
        self.subjects = [
            {"id": "CS101", "name": "Programming Fundamentals", "hours_per_week": 3, "lab_required": True},
            {"id": "CS102", "name": "Data Structures", "hours_per_week": 3, "lab_required": True},
            {"id": "CS201", "name": "Object Oriented Programming", "hours_per_week": 3, "lab_required": True},
            {"id": "CS202", "name": "Database Systems", "hours_per_week": 3, "lab_required": True},
            {"id": "CS301", "name": "Software Engineering", "hours_per_week": 3, "lab_required": False},
            {"id": "CS302", "name": "Computer Networks", "hours_per_week": 3, "lab_required": True},
            {"id": "CS401", "name": "Artificial Intelligence", "hours_per_week": 3, "lab_required": True},
            {"id": "CS402", "name": "Machine Learning", "hours_per_week": 3, "lab_required": True},
            {"id": "MATH101", "name": "Calculus I", "hours_per_week": 3, "lab_required": False},
            {"id": "MATH201", "name": "Discrete Mathematics", "hours_per_week": 3, "lab_required": False},
            {"id": "ENG101", "name": "English Composition", "hours_per_week": 2, "lab_required": False},
            {"id": "PHY101", "name": "Physics", "hours_per_week": 3, "lab_required": True}
        ]

        self.teachers = [
            {"id": "T001", "name": "Dr. Ahmed Khan", "subjects": ["CS101", "CS201"], "max_hours": 18},
            {"id": "T002", "name": "Dr. Sarah Ali", "subjects": ["CS102", "CS202"], "max_hours": 18},
            {"id": "T003", "name": "Prof. Muhammad Hassan", "subjects": ["CS301", "CS401"], "max_hours": 15},
            {"id": "T004", "name": "Dr. Fatima Sheikh", "subjects": ["CS302", "CS402"], "max_hours": 18},
            {"id": "T005", "name": "Dr. Omar Farooq", "subjects": ["MATH101", "MATH201"], "max_hours": 20},
            {"id": "T006", "name": "Ms. Ayesha Malik", "subjects": ["ENG101"], "max_hours": 12},
            {"id": "T007", "name": "Dr. Bilal Ahmad", "subjects": ["PHY101"], "max_hours": 15}
        ]

        self.rooms = [
            {"id": "R101", "type": "lecture", "capacity": 60},
            {"id": "R102", "type": "lecture", "capacity": 50},
            {"id": "R103", "type": "lecture", "capacity": 40},
            {"id": "LAB1", "type": "lab", "capacity": 30},
            {"id": "LAB2", "type": "lab", "capacity": 30},
            {"id": "LAB3", "type": "lab", "capacity": 25},
            {"id": "LAB4", "type": "lab", "capacity": 25}
        ]

        self.student_groups = [
            {"id": "CS-1A", "semester": 1, "students": 45, "subjects": ["CS101", "MATH101", "ENG101"]},
            {"id": "CS-1B", "semester": 1, "students": 40, "subjects": ["CS101", "MATH101", "ENG101"]},
            {"id": "CS-3A", "semester": 3, "students": 38, "subjects": ["CS201", "CS202", "MATH201"]},
            {"id": "CS-3B", "semester": 3, "students": 35, "subjects": ["CS201", "CS202", "MATH201"]},
            {"id": "CS-5A", "semester": 5, "students": 32, "subjects": ["CS301", "CS302", "PHY101"]},
            {"id": "CS-7A", "semester": 7, "students": 28, "subjects": ["CS401", "CS402"]},
            {"id": "CS-7B", "semester": 7, "students": 25, "subjects": ["CS401", "CS402"]}
        ]

        # Time slots (Monday to Friday, 8 AM to 5 PM)
        self.time_slots = []
        days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]
        for day in days:
            for hour in range(8, 17):  # 8 AM to 5 PM
                self.time_slots.append({
                    "id": f"{day}_{hour}",
                    "day": day,
                    "start_time": f"{hour:02d}:00",
                    "end_time": f"{hour+1:02d}:00"
                })

        # Genetic Algorithm Parameters
        self.population_size = 100
        self.generations = 500
        self.mutation_rate = 0.1
        self.crossover_rate = 0.8
        self.elite_size = 10

    def create_individual(self) -> List[Dict]:
        """Create a random timetable individual"""
        individual = []

        for group in self.student_groups:
            for subject_id in group["subjects"]:
                subject = next(s for s in self.subjects if s["id"] == subject_id)

                # Assign theory classes
                for _ in range(subject["hours_per_week"]):
                    # Find available teacher
                    available_teachers = [t for t in self.teachers if subject_id in t["subjects"]]
                    if not available_teachers:
                        continue

                    teacher = random.choice(available_teachers)

                    # Find appropriate room
                    room_type = "lab" if subject["lab_required"] and random.random() < 0.3 else "lecture"
                    available_rooms = [r for r in self.rooms if r["type"] == room_type and r["capacity"] >= group["students"]]
                    if not available_rooms:
                        available_rooms = [r for r in self.rooms if r["capacity"] >= group["students"]]

                    if not available_rooms:
                        continue

                    room = random.choice(available_rooms)
                    time_slot = random.choice(self.time_slots)

                    class_entry = {
                        "group_id": group["id"],
                        "subject_id": subject_id,
                        "teacher_id": teacher["id"],
                        "room_id": room["id"],
                        "time_slot_id": time_slot["id"],
                        "day": time_slot["day"],
                        "start_time": time_slot["start_time"],
                        "type": "lab" if room["type"] == "lab" else "lecture"
                    }
                    individual.append(class_entry)

        return individual

    def calculate_fitness(self, individual: List[Dict]) -> float:
        """Calculate fitness score (lower is better)"""
        conflicts = 0

        # Check for conflicts
        for i, class1 in enumerate(individual):
            for j, class2 in enumerate(individual[i+1:], i+1):
                # Same time slot conflicts
                if class1["time_slot_id"] == class2["time_slot_id"]:
                    # Teacher conflict
                    if class1["teacher_id"] == class2["teacher_id"]:
                        conflicts += 10

                    # Room conflict
                    if class1["room_id"] == class2["room_id"]:
                        conflicts += 10

                    # Student group conflict
                    if class1["group_id"] == class2["group_id"]:
                        conflicts += 15

        # Check teacher workload
        teacher_hours = {}
        for class_entry in individual:
            teacher_id = class_entry["teacher_id"]
            teacher_hours[teacher_id] = teacher_hours.get(teacher_id, 0) + 1

        for teacher_id, hours in teacher_hours.items():
            teacher = next(t for t in self.teachers if t["id"] == teacher_id)
            if hours > teacher["max_hours"]:
                conflicts += (hours - teacher["max_hours"]) * 5

        # Check room capacity
        for class_entry in individual:
            room = next(r for r in self.rooms if r["id"] == class_entry["room_id"])
            group = next(g for g in self.student_groups if g["id"] == class_entry["group_id"])
            if group["students"] > room["capacity"]:
                conflicts += 8

        # Prefer balanced daily distribution
        daily_classes = {}
        for class_entry in individual:
            day = class_entry["day"]
            group_id = class_entry["group_id"]
            key = f"{group_id}_{day}"
            daily_classes[key] = daily_classes.get(key, 0) + 1

        for count in daily_classes.values():
            if count > 4:  # More than 4 classes per day
                conflicts += (count - 4) * 2

        return conflicts

    def tournament_selection(self, population: List[Tuple], tournament_size: int = 5) -> List[Dict]:
        """Select parent using tournament selection"""
        tournament = random.sample(population, min(tournament_size, len(population)))
        return min(tournament, key=lambda x: x[1])[0]

    def crossover(self, parent1: List[Dict], parent2: List[Dict]) -> Tuple[List[Dict], List[Dict]]:
        """Single-point crossover"""
        if random.random() > self.crossover_rate:
            return parent1.copy(), parent2.copy()

        crossover_point = random.randint(1, min(len(parent1), len(parent2)) - 1)

        child1 = parent1[:crossover_point] + parent2[crossover_point:]
        child2 = parent2[:crossover_point] + parent1[crossover_point:]

        return child1, child2

    def mutate(self, individual: List[Dict]) -> List[Dict]:
        """Mutate individual by changing random class assignments"""
        if random.random() > self.mutation_rate:
            return individual

        mutated = individual.copy()

        if len(mutated) > 0:
            # Random mutation: change time slot, room, or teacher
            class_to_mutate = random.choice(mutated)
            mutation_type = random.choice(["time", "room", "teacher"])

            if mutation_type == "time":
                class_to_mutate["time_slot_id"] = random.choice(self.time_slots)["id"]
                new_slot = random.choice(self.time_slots)
                class_to_mutate["day"] = new_slot["day"]
                class_to_mutate["start_time"] = new_slot["start_time"]

            elif mutation_type == "room":
                subject = next(s for s in self.subjects if s["id"] == class_to_mutate["subject_id"])
                group = next(g for g in self.student_groups if g["id"] == class_to_mutate["group_id"])

                room_type = "lab" if subject["lab_required"] and random.random() < 0.3 else "lecture"
                available_rooms = [r for r in self.rooms if r["type"] == room_type and r["capacity"] >= group["students"]]
                if available_rooms:
                    class_to_mutate["room_id"] = random.choice(available_rooms)["id"]

            elif mutation_type == "teacher":
                available_teachers = [t for t in self.teachers if class_to_mutate["subject_id"] in t["subjects"]]
                if available_teachers:
                    class_to_mutate["teacher_id"] = random.choice(available_teachers)["id"]

        return mutated

    def generate_timetable(self) -> Dict:
        """Main genetic algorithm function"""
        print("🧬 Starting Genetic Algorithm for Timetable Generation...")
        print(f"📊 Population Size: {self.population_size}")
        print(f"🔄 Generations: {self.generations}")
        print(f"🎯 Target: Conflict-free timetable for Computer Science students")

        # Initialize population
        population = []
        for _ in range(self.population_size):
            individual = self.create_individual()
            fitness = self.calculate_fitness(individual)
            population.append((individual, fitness))

        best_fitness_history = []

        for generation in range(self.generations):
            # Sort population by fitness
            population.sort(key=lambda x: x[1])
            best_fitness = population[0][1]
            best_fitness_history.append(best_fitness)

            if generation % 50 == 0:
                print(f"Generation {generation}: Best Fitness = {best_fitness}")

            # Early termination if perfect solution found
            if best_fitness == 0:
                print(f"🎉 Perfect solution found at generation {generation}!")
                break

            # Create new population
            new_population = []

            # Keep elite individuals
            for i in range(self.elite_size):
                new_population.append(population[i])

            # Generate offspring
            while len(new_population) < self.population_size:
                parent1 = self.tournament_selection(population)
                parent2 = self.tournament_selection(population)

                child1, child2 = self.crossover(parent1, parent2)
                child1 = self.mutate(child1)
                child2 = self.mutate(child2)

                fitness1 = self.calculate_fitness(child1)
                fitness2 = self.calculate_fitness(child2)

                new_population.append((child1, fitness1))
                if len(new_population) < self.population_size:
                    new_population.append((child2, fitness2))

            population = new_population

        # Get best solution
        population.sort(key=lambda x: x[1])
        best_individual, best_fitness = population[0]

        print(f"✅ Algorithm completed!")
        print(f"🏆 Best fitness achieved: {best_fitness}")
        print(f"📈 Improvement: {best_fitness_history[0]} → {best_fitness}")

        # Format result
        result = {
            "success": True,
            "fitness_score": best_fitness,
            "total_classes": len(best_individual),
            "generations_run": generation + 1,
            "timetable": self.format_timetable(best_individual),
            "statistics": {
                "initial_fitness": best_fitness_history[0],
                "final_fitness": best_fitness,
                "improvement_percentage": ((best_fitness_history[0] - best_fitness) / best_fitness_history[0] * 100) if best_fitness_history[0] > 0 else 100
            }
        }

        return result

    def format_timetable(self, individual: List[Dict]) -> Dict:
        """Format timetable for display"""
        formatted = {
            "by_day": {},
            "by_group": {},
            "by_teacher": {},
            "by_room": {}
        }

        # Group by day
        for class_entry in individual:
            day = class_entry["day"]
            if day not in formatted["by_day"]:
                formatted["by_day"][day] = []

            # Get additional info
            subject = next(s for s in self.subjects if s["id"] == class_entry["subject_id"])
            teacher = next(t for t in self.teachers if t["id"] == class_entry["teacher_id"])
            room = next(r for r in self.rooms if r["id"] == class_entry["room_id"])
            group = next(g for g in self.student_groups if g["id"] == class_entry["group_id"])

            formatted_class = {
                "time": class_entry["start_time"],
                "subject": subject["name"],
                "teacher": teacher["name"],
                "room": room["id"],
                "group": group["id"],
                "type": class_entry["type"],
                "students": group["students"]
            }

            formatted["by_day"][day].append(formatted_class)

        # Sort by time
        for day in formatted["by_day"]:
            formatted["by_day"][day].sort(key=lambda x: x["time"])

        # Group by student group
        for class_entry in individual:
            group_id = class_entry["group_id"]
            if group_id not in formatted["by_group"]:
                formatted["by_group"][group_id] = []

            subject = next(s for s in self.subjects if s["id"] == class_entry["subject_id"])
            teacher = next(t for t in self.teachers if t["id"] == class_entry["teacher_id"])

            formatted["by_group"][group_id].append({
                "day": class_entry["day"],
                "time": class_entry["start_time"],
                "subject": subject["name"],
                "teacher": teacher["name"],
                "room": class_entry["room_id"],
                "type": class_entry["type"]
            })

        return formatted

# Run the algorithm
if __name__ == "__main__":
    generator = TimetableGeneticAlgorithm()
    result = generator.generate_timetable()

    print("\n" + "="*60)
    print("🎓 UNIVERSITY OF COMPUTER SCIENCE - TIMETABLE GENERATED")
    print("="*60)

    if result["success"]:
        print(f"✅ Generation Status: SUCCESS")
        print(f"🎯 Fitness Score: {result['fitness_score']} conflicts")
        print(f"📚 Total Classes: {result['total_classes']}")
        print(f"🔄 Generations: {result['generations_run']}")
        print(f"📈 Improvement: {result['statistics']['improvement_percentage']:.1f}%")

        print("\n📅 WEEKLY SCHEDULE:")
        for day, classes in result["timetable"]["by_day"].items():
            print(f"\n{day.upper()}:")
            for class_info in classes:
                print(f"  {class_info['time']} | {class_info['subject']} | {class_info['group']} | {class_info['teacher']} | {class_info['room']}")

        # Save to JSON file
        with open('generated_timetable.json', 'w') as f:
            json.dump(result, f, indent=2)

        print(f"\n💾 Timetable saved to 'generated_timetable.json'")
    else:
        print("❌ Timetable generation failed")
