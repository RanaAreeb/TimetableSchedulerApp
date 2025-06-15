# Timetable Scheduler App

A comprehensive Android application for managing academic timetables with role-based authentication and Firebase integration.

## Features

- **Role-based Authentication**: Student, Teacher, and Batch Coordinator roles
- **Modern Material 3 Design**: Clean UI with gradients and rounded cards
- **Firebase Integration**: Authentication, Firestore database, and Cloud Messaging
- **Timetable Management**: View and manage class schedules
- **Real-time Notifications**: Push notifications for updates
- **AI-powered Timetable Generation**: (Stub implementation for future development)

## Setup Instructions

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24 or higher
- Firebase project setup

### Installation

1. **Clone or download the project**
2. **Open in Android Studio**
3. **Firebase Setup**:
   - Create a new Firebase project at https://console.firebase.google.com
   - Add an Android app with package name: `com.example.timeatbleschedulerapp`
   - Download the `google-services.json` file
   - Replace the placeholder `google-services.json` in the `app/` directory
   - Enable Authentication (Email/Password) in Firebase Console
   - Enable Firestore Database in Firebase Console
   - Enable Cloud Messaging in Firebase Console

4. **Build and Run**:
   - Sync the project with Gradle files
   - Build and run on an Android device or emulator

### Project Structure

\`\`\`
app/
├── src/main/java/com/example/timeatbleschedulerapp/
│   ├── data/
│   │   ├── models/          # Data models (User, Batch, etc.)
│   │   └── repository/      # Repository classes
│   ├── di/                  # Dependency injection modules
│   ├── services/            # Firebase messaging service
│   ├── ui/
│   │   ├── screens/         # Activity and Fragment classes
│   │   └── theme/           # Compose theme files
│   └── navigation/          # Navigation components
├── src/main/res/
│   ├── layout/              # XML layout files
│   ├── drawable/            # Vector drawables and icons
│   ├── values/              # Colors, strings, themes
│   └── menu/                # Menu resources
└── google-services.json     # Firebase configuration
\`\`\`

### Key Technologies

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit (mixed with XML layouts)
- **Firebase**: Backend services (Auth, Firestore, FCM)
- **Hilt**: Dependency injection
- **Material 3**: Design system
- **Navigation Component**: App navigation
- **ViewBinding**: View binding for XML layouts

### User Roles

1. **Student**: View timetable, receive notifications, contact teachers
2. **Teacher**: Send notifications, view timetable, manage class lists
3. **Batch Coordinator**: Generate timetables, assign schedules, manage notifications

### Future Enhancements

- Complete AI-powered timetable generation
- Offline data synchronization
- Advanced analytics and reporting
- Push notification customization
- Dark theme support
- Multi-language support

### Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

### License

This project is for educational purposes. Please ensure you have proper Firebase configuration before running.
