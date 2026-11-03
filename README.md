<p align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" alt="Determinantes e Simplex App Icon" width="120" height="120">
</p>
<h1 align="center">Determinantes e Simplex</h1>

<p align="center">
  <a href="https://play.google.com/store/apps/details?id=br.com.arsgapps.determinantessimplex"><img src="https://img.shields.io/badge/Google%20Play-Available-brightgreen?style=for-the-badge&logo=google-play" alt="Google Play"></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge" alt="License: MIT"></a>
  <a href="https://kotlinlang.org"><img src="https://img.shields.io/badge/Kotlin-2.0.21-orange?style=for-the-badge&logo=kotlin" alt="Kotlin"></a>
  <a href="https://developer.android.com/jetpack/compose"><img src="https://img.shields.io/badge/Jetpack%20Compose-UI-blue?style=for-the-badge&logo=jetpackcompose" alt="Jetpack Compose"></a>
</p>

**Determinantes e Simplex** is a modern, high-performance Android application built for students, engineers, and mathematics professionals. It solves matrix determinants ($2\times2$, $3\times3$, $4\times4$, and general $N\timesN$ via Gaussian Elimination with Partial Pivoting) and linear programming problems using the Simplex Method.

Available in **Portuguese**, **English**, and **Spanish**.

---

## 📱 Features

- **Matrix Determinants ($N \times N$):** Dedicated calculators for 2x2, 3x3, 4x4, and higher-order matrices using robust numerical algorithms.
- **Simplex Method Solver:** Automated linear programming solver for maximization problems with linear constraints ($\le$).
- **Adaptive UI & Material 3:** Built with Jetpack Compose and Material 3, featuring an adaptive landscape layout (2x2 grid with zero scrolling).
- **Theoretical Foundation & Examples:** In-app explanations and step-by-step solved examples for each method.
- **Multi-language Support:** Fully localized in Portuguese (`pt-BR`), English (`en-US`), and Spanish (`es-ES`).
- **Offline-First & Optimized:** 100% on-device processing with R8 code optimization and native debug symbol support.

---

## 📥 Get the App on Google Play

You can download the official release directly from the Google Play Store:
[🔗 Determinantes e Simplex on Google Play](https://play.google.com/store/apps/details?id=br.com.arsgapps.determinantessimplex)

---

## 🛠️ Tech Stack

- **Language:** Kotlin 2.0.21
- **UI Toolkit:** Jetpack Compose & Material 3
- **Architecture:** Declarative UI with ViewModel & StateFlow
- **Build System:** Gradle with Android Gradle Plugin (AGP) & R8 Optimization
- **Testing:** JUnit & Compose UI Testing (E2E)

---

## 🤝 Contributing

We love contributions from the open-source community! Whether it's reporting a bug, improving documentation, or proposing a new feature, your help is welcome.

### Git Flow & Contribution Workflow

We follow standard Git Flow practices to ensure a clean and collaborative development process:

1. **Fork the Repository**
   Click the **Fork** button at the top right of this repository to create a copy under your GitHub account.

2. **Clone Your Fork**
   ```bash
   git clone https://github.com/YOUR-USERNAME/determinantes-e-simplex.git
   cd determinantes-e-simplex
   ```

3. **Create a Feature Branch**
   Always create your branch from `main` (or `develop`):
   ```bash
   git checkout main
   git pull origin main
   git checkout -b feature/your-feature-name
   ```
   *Branch naming convention:*
   - `feature/short-description` (for new features)
   - `fix/short-description` (for bug fixes)
   - `docs/short-description` (for documentation updates)

4. **Make Your Changes**
   - Implement your changes following Kotlin and Jetpack Compose best practices.
   - Ensure all hardcoded UI strings are added to `strings.xml` across all locales (`values`, `values-en`, `values-es`).

5. **Run Tests and Build**
   Verify that your code compiles and all unit tests pass successfully:
   ```bash
   ./gradlew testDebugUnitTest
   ./gradlew assembleDebug
   ```

6. **Commit Your Changes**
   Use clear, descriptive commit messages following the Conventional Commits style:
   ```bash
   git add .
   git commit -m "feat: add matrix inverse calculation feature"
   ```
   *Prefixes:* `feat:`, `fix:`, `docs:`, `refactor:`, `test:`, `chore:`

7. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

8. **Open a Pull Request (PR)**
   - Go to the original repository and open a Pull Request against the `main` branch.
   - Provide a clear description of your changes, referencing any related issues.
   - **PR Reviewer:** [@andrersguedes](https://github.com/andrersguedes) will review your contributions.

---

## 👥 Maintainers & Reviewers

- **Lead Maintainer & PR Reviewer:** [@andrersguedes](https://github.com/andrersguedes)

---

## 📄 License

This project is open-source software licensed under the [MIT License](LICENSE).
