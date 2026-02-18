Architecture starter template (multi-module)
==================

This template is compatible with the latest **stable** version of Android Studio.

![Screenshot](https://github.com/android/architecture-templates/raw/main/screenshots.png)

## Features

* Room Database
* Hilt
* ViewModel, read+write
* UI in Compose, list + write (Material3)
* Navigation
* Repository and data source
* Kotlin Coroutines and Flow
* Unit tests
* UI tests using fake data with Hilt

## Modules
The following module types are used:

- `core` modules contain objects that are used by one or more feature modules.
- `feature-mymodel` contains the `mymodel` feature.
- `feature-mymodel-navigation` contains the navigation keys for the `mymodel` feature. This allows other feature modules to navigate to `mymodel`'s screens without creating a dependency on `feature-mymodel`. An alternative approach is to use an [api / implementation split](https://developer.android.com/topic/modularization/patterns#dependency_injection).

Check the [modularization guidance](https://developer.android.com/topic/modularization) for more information.

## Usage

1. Clone this branch

```
git clone https://github.com/android/architecture-templates.git --branch multimodule
```


2. Run the customizer script:

```
./customizer.sh your.package.name DataItemType [MyApplication]
```

Where `your.package.name` is your app ID (should be lowercase) and `DataItemType` is used for the
name of the screen, exposed state and data base entity (should be PascalCase). You can add an optional application name.

# License

Now in Android is distributed under the terms of the Apache License (Version 2.0). See the
[license](LICENSE) for more information.
