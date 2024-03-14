# Opn Coding Challenge

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Dependencies](#dependencies)

## Installation

1. Clone the repository with ssh to your local machine:

    ```bash
    git clone git@github.com:KurosakiKST/opn-coding-challenge.git
    ```

2. Change the directory to 'opn-coding-challenge'

   ```bash
   cd opn-coding-challenge
   ```

3. Open the project in Android Studio.

4. Build and run the project on an Android device or emulator.

## Usage

## context

1. Added ecommerce store features such as 

- Product selection & quantity update
- Add to basket
- Checkout
- Returning to home screen to make another purchase again.

## changes

- Used MVVM architecture
- Separate layers for data manipulation such as domain layer and UI layer
- Used Jetpack compose to accelerate UI development
- Used a chucker for easier debugging of api call

## assumptions & mistakes

- I was failed to make the selected product persistent so the checkout flow will be a bit of a bad UX.
- I used Mockito to write Unit Tests but due to the rush in development, \n I forgot to separate the Logic and UI in usecase, so I couldn't able to make the test cases to be successfully run
- And there's some UI inconsistency too.

## screenshots
| Screenshot 1 | Screenshot 2 | Screenshot 3 |
|---------------|---------------|---------------|
| ![Screenshot_1710406594](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/617fdbec-7aaf-4831-8cb5-a4e358f11dc9) | ![Screenshot_1710406718](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/6aa074bf-466d-403c-940c-b5f63b07f215) | ![Screenshot_1710406604](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/774d9ece-5aa6-4fed-ab26-a1b61a1953a3) |

| Screenshot 4 | Screenshot 5 | Screenshot 6 |
|---------------|---------------|---------------|
| ![Screenshot_1710406608](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/490a993d-389a-42c6-86ca-880e48aa572d) | ![Screenshot_1710406618](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/0c73a9a8-5c91-46a8-9e5c-4d257dcc095f) | ![Screenshot_1710406625](https://github.com/KurosakiKST/opn-coding-challenge/assets/28829665/e016cae1-78de-4b0c-abe6-ad22cb307d4e) |

## Dependencies

- Compose Navigation
- Coroutines 
- Flow
- Retrofit 2
- GSON body parser
- Coil
- Hilt
- Testing
- Mockito
- Chucker
