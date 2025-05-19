## CryptoLook App
A real-time cryptocurrency tracking application utilizing the CryptoCompare API.

### 📱 Screenshots

| <img width="250px" src="https://github.com/unoth/CryptoLookApp/assets/96779254/5d0250f4-1f86-4b26-b4ab-f07b2f321e25" alt="CryptoLookApp_MainActivity"/> |  <img width="250px" src="https://github.com/unoth/CryptoLookApp/assets/96779254/0e0502db-29ba-4fa9-adad-0bd67c3b0475" alt="CryptoLookApp_DetailInfo"/>| 
|:---:|:---:|
| Main screen | Detailed information screen | 


|  <img width="550px" src="https://github.com/user-attachments/assets/eb6f91db-ce55-4ed6-9975-c71c92837643" alt="CryptoLookApp_Landscape"/> | <img width="550px" src="https://github.com/user-attachments/assets/306e0fa0-6920-4fab-9a5b-ee7949a3e7de" alt="CryptoLookApp_Landscape_Fragments"/>| 
|:---:|:---:|
| Landscape orientation | Landscape orientation with Fragments | 







 ❕ ❕ ❕ UPD_1.0:
- Architectural layers added: data, domain, presentation.
- Mappers implemented.
- RxJava -> Coroutines.
- Adapter refactored.
- Methods moved from POJO to mappers.
- Landscape orientation support added: transitioned Activity to Fragments.
- Background loading implemented using WorkManager.

---




📊 Functionality: Displays the current exchange rates of the most popular cryptocurrencies with real-time updates.

📲 Detailed Information: Clicking on a currency provides detailed information, including the current price, the highest and lowest prices, and the stores where the currency can be purchased.

🔍 Technologies: The application is built on the MVVM architecture, uses Room for local data storage, and Retrofit for network requests.



**Technology Stack:**

- API: CryptoCompare

- Architecture: MVVM

- Database: Room

- Network Requests: Retrofit
