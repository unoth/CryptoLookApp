# CryptoLook App
**CryptoLook** is a real-time cryptocurrency tracking app powered by the CryptoCompare API.  



## 📱 Screenshots

| <img width="250px" src="https://github.com/unoth/CryptoLookApp/assets/96779254/5d0250f4-1f86-4b26-b4ab-f07b2f321e25" alt="CryptoLookApp_MainActivity"/> |  <img width="250px" src="https://github.com/unoth/CryptoLookApp/assets/96779254/0e0502db-29ba-4fa9-adad-0bd67c3b0475" alt="CryptoLookApp_DetailInfo"/>| 
|:---:|:---:|
| Main screen | Detailed information screen | 


|  <img width="550px" src="https://github.com/user-attachments/assets/eb6f91db-ce55-4ed6-9975-c71c92837643" alt="CryptoLookApp_Landscape"/> | <img width="550px" src="https://github.com/user-attachments/assets/306e0fa0-6920-4fab-9a5b-ee7949a3e7de" alt="CryptoLookApp_Landscape_Fragments"/>| 
|:---:|:---:|
| Landscape orientation | Landscape orientation with Fragments | 




## 🚀 Features

-  Real-time tracking of popular cryptocurrencies  
-  Detailed view with current price, daily high/low, and markets  
-  Landscape mode support with Fragment-based UI  
-  Background data loading using WorkManager  
-  Clean and modular architecture using MVVM


## 🛠️ Technology Stack

- **API:** [CryptoCompare](https://min-api.cryptocompare.com/)  
- **Architecture:** Clean Architecture (MVVM — Data, Domain, Presentation layers)  
- **DI:** Dagger 2  
- **Async:** Kotlin Coroutines  
- **Database:** Room  
- **Networking:** Retrofit  
- **UI:** Fragments, RecyclerView  

---

## 📦 Changelog

### v1.1
- Implemented Dependency Injection with Dagger 2


### v1.0
- Refactored architecture: introduced Data, Domain, and Presentation layers  
- Implemented custom mappers  
- Migrated from **RxJava** to **Coroutines**  
- Moved logic from POJOs to mappers  
- Refactored adapter  
- Added landscape mode with Fragment layout  
- Enabled background loading with **WorkManager**
