# Custom ViewModel Library (Android)

This project demonstrates how Android’s `ViewModel` architecture component works under the hood. It includes a custom implementation of:

- `ViewModel`
- `ViewModelStore`
- `ViewModelOwner`
- `ViewModelProvider`

The purpose is to help developers understand the internal behavior of `androidx.lifecycle.ViewModel` — especially how it survives configuration changes and manages the lifecycle of UI-related data.

---

## 📌 What You'll Learn

- How `ViewModel` retains data across configuration changes (like screen rotation).
- How `ViewModelStore` holds ViewModel instances.
- How `ViewModelProvider` retrieves or creates ViewModels using keys.
- How the Activity manages the ViewModel lifecycle using `onRetainCustomNonConfigurationInstance()` and `onDestroy()`.

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/sravanipamu/ViewModelLibrary.git

