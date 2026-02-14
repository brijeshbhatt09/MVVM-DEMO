# 📱 MVVM-DEMO – Android Architecture Sample

A structured Android application demonstrating **MVVM (Model–View–ViewModel)** architecture with clear separation of concerns across Presentation, ViewModel, Repository, Data, and Persistence layers.

This project showcases scalable Android development practices using Room, Retrofit, Coroutines, and lifecycle-aware components.

---

## 🏗 Architecture Overview

The application follows a layered MVVM architecture:

UI (Presentation Layer)  
↓  
ViewModel Layer  
↓  
Repository Layer  
↓  
Data Layer  
   ├── Network (Retrofit)  
   └── Persistence (Room)  

Each layer has a defined responsibility, ensuring maintainability, scalability, and testability.

---

## 📂 Project Structure

app/
└── src/main/java/com/example/...
├── data/
│ ├── network/
│ ├── Persistence/
│ ├── AppDataManager.kt
│ └── DataManager.kt
│
├── interfaces/
│ └── ILoadMoreContent.kt
│
├── model/
│
├── repository/
│
├── ui/
│ ├── adapter/
│ │ ├── CustomBindingadapter.kt
│ │ └── HomeAdapter.kt
│ └── MainActivity.kt
│
└── viewmodel/


---

## 🧱 Layer Breakdown

### 1️⃣ Presentation Layer (`ui`)
- Contains Activities and Adapters
- Handles user interaction
- Observes LiveData from ViewModel
- Displays RecyclerView list

---

### 2️⃣ ViewModel Layer (`viewmodel`)
- Manages UI-related state
- Communicates with Repository
- Lifecycle-aware
- Survives configuration changes

---

### 3️⃣ Repository Layer (`repository`)
- Single source of truth
- Coordinates between Network and Local DB
- Abstracts data logic from ViewModel

---

### 4️⃣ Data Layer (`data`)

#### 🔹 Network Layer (`network`)
- Retrofit-based API communication

#### 🔹 Persistence Layer (`Persistence`)
- Room database for local storage
- Supports offline-first approach

#### 🔹 Data Managers
- AppDataManager
- DataManager
- Centralized data handling abstraction

---

### 5️⃣ Model Layer (`model`)
- Data classes
- API response models
- Room entity models

---

### 6️⃣ Interfaces Layer (`interfaces`)
- Defines contracts and callbacks
- Improves decoupling and testability

---

## 🚀 Tech Stack

### Core
- Kotlin
- AndroidX
- RecyclerView
- ConstraintLayout
- CardView

### Architecture Components
- ViewModel
- LiveData
- Lifecycle
- MVVM Pattern

### Asynchronous Programming
- Kotlin Coroutines

### Networking
- Retrofit
- Gson Converter
- OkHttp Logging Interceptor

### Local Storage
- Room Database

### Testing
- JUnit
- Espresso

---

## 🔄 Data Flow

1. UI triggers event  
2. ViewModel processes request  
3. Repository determines data source  
4. Data fetched from:
   - Network (API)
   - Room (Local Cache)
5. LiveData updates UI  
6. RecyclerView reflects changes  

---

## 🎯 Key Concepts Demonstrated

- Clean separation of layers  
- Offline-first data strategy  
- Lifecycle-aware architecture  
- Repository pattern  
- Scalable Android structure  


## 👨‍💻 Author

**Brijesh Bhatt**  
Mobile Architect | Android & iOS | AI-Driven Systems | Scalable & Offline-First Architecture

---

## ⭐ Purpose

This project is intended as an architectural reference for developers who want to understand practical MVVM implementation in Android.
