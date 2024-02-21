                                           Social Media Clone App
Overview
A platform that users can use for their social media stuff - like posting, messaging and connecting with friends easily.

## 📷 Previews
![1](https://github.com/shubhanshu24510/SocialClone/assets/100926922/a7be9795-0499-435d-9bf6-975089b977b8)
![2](https://github.com/shubhanshu24510/SocialClone/assets/100926922/05d6f366-b4e5-4fb2-8a32-453ddc56b001)

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/gemini-android/actions/workflows/android.yml"><img alt="Build Status" src="https://github.com/skydoves/gemini-android/actions/workflows/android.yml/badge.svg"/></a>

</p>

🚀 Key Features:
- Responsive UI
- Native Android App
- Material Design Components
- Comprehensive Search
-Auth Features Login and Sign Up
-Channel Home
-Chat Message Stuff
- Like and Comment Features
-Search friends Stuff
- Navigation Rail for Foldable Devices
-Post picture features
- Library
- Shimmer Loading Screen
-Channel Details Screen
-Connecting with Friends Features Like Follow and Following
-Edit Profile Features
- Top Categories

### Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
* [Ktor client library](https://github.com/ktorio/ktor)
* [Timber](com.jakewharton.timber:timber:4.2.0)
* [Kotlin Coroutine](https://github.com/Kotlin/kotlinx.coroutines)
* [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Retrofit](https://square.github.io/retrofit/)
* [Scarlet](https://github.com/Tinder/Scarlet)
* [KMongo](https://litote.org/kmongo/quick-start/)
* [Ktor](https://ktor.io/docs/client-dependencies.html)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)
* [Koin](https://github.com/InsertKoinIO/koin)
* [Jetpack Compose](https://developer.android.com/jetpack/compose)
* [Coil](https://coil-kt.github.io/coil/)

The overall architecture is composed of two layers; UI Layer and the data layer. Each layer has dedicated components and they each have different responsibilities.
The arrow means the component has a dependency on the target component following its direction.

### Architecture Overview

![layer](figures/figure1.png)

Each layer has different responsibilities below. Basically, they follow [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf).

### UI Layer

![layer](figures/figure2.png)

The UI Layer consists of UI elements like buttons, menus, tabs that could interact with users and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.

### Data Layer

![layer](figures/figure3.png)

The data Layer consists of repositories, which include business logic, such as querying data from the local database and requesting remote data from the network. It is implemented as an offline-first source of business logic and follows the [single source of truth](https://en.wikipedia.org/wiki/Single_source_of_truth) principle.<br>

## 💯 MAD Score

![summary](https://user-images.githubusercontent.com/24237865/158918011-bc766482-ec83-47dd-9237-d8a226cab263.png)


