# 📦 File Packer & Unpacker with Encryption

### (Java | CUI + GUI)

## 📌 Description

The **File Packer & Unpacker with Encryption** is a Java-based application that allows users to **combine multiple files into a single packed file** and later restore them using an unpacking process.

To ensure data security, the project integrates **encryption and decryption mechanisms**, protecting the contents from unauthorized access.

The project provides two interfaces:

* 🖥️ **CUI (Console User Interface)** – lightweight, terminal-based usage
* 🪟 **GUI (Graphical User Interface)** – user-friendly visual interaction

👉 File packing combines multiple files into one archive, while unpacking restores them using stored metadata and structure ([IJCRT][1])

---

## 🚀 Features

* 📦 Pack multiple files into a single archive
* 📂 Unpack archive into original files
* 🔐 Encryption & decryption for data security
* 🧠 Metadata management for file reconstruction
* 🖥️ Dual interface:

  * CUI (terminal-based)
  * GUI (Swing/AWT based)
* ⚡ Platform independent (Java)

---

## 🛠️ Technologies Used

* Language: **Java**
* Concepts:

  * File Handling (`FileInputStream`, `FileOutputStream`)
  * Object-Oriented Programming
  * Encryption / Decryption
  * Metadata handling
* GUI:

  * Java Swing / AWT

---

## 📂 Project Structure

```bash
File-Packer-Unpacker-with-Encryption/
│── CUI/
│   ├── Packer.java
│   ├── Unpacker.java
│   ├── Main.java
│
│── GUI/
│   ├── PackerGUI.java
│   ├── UnpackerGUI.java
│   ├── MainFrame.java
│
│── Output/
│   ├── PackedFile.marv
│
│── README.md
```

---

## ⚙️ How It Works

### 🔹 Packing Process

1. Accept directory from user
2. Read all files from directory
3. Store:

   * File name
   * File size
   * File data
4. Encrypt data
5. Store everything into a **single packed file**

👉 Packed file acts like an archive containing metadata + encrypted data ([IJCRT][1])

---

### 🔹 Unpacking Process

1. Read packed file
2. Decrypt stored data
3. Extract metadata
4. Recreate original files
5. Restore directory structure

---

## 🧑‍💻 How to Run

### 🔧 Compile (CUI)

```bash
javac Main.java
```

### ▶️ Run (CUI)

```bash
java Main
```

---

### 🪟 Run GUI Version

```bash
javac MainFrame.java
java MainFrame
```

---

## 🔒 Requirements

* Java JDK 8 or above
* Any OS (Windows/Linux/Mac)
* Basic understanding of file handling

---

## 📈 Future Improvements

* 📉 Add compression (reduce file size like ZIP)
* 🔑 Password-based encryption
* 🧠 Integrity check (checksum validation)
* 📊 Progress bar in GUI
* ☁️ Cloud storage support

---

## 💡 Learning Outcomes

* File system handling in Java
* Data encryption and security concepts
* Designing archive-based systems
* GUI + CUI application development
* Real-world project architecture

---

## 👤 Author

**Kartik Ganesh Jare**

---

## ⭐ Why This Project Matters

This project combines:

* File handling
* Security (encryption)
* System design
* GUI + CLI development

It demonstrates the ability to build **real-world utilities similar to ZIP/WinRAR tools**, which use archive formats to store multiple files efficiently
---

[1]: https://ijcrt.org/papers/IJCRT2106787.pdf?utm_source=chatgpt.com "Design & Implementation of Unpacker From file Packer ..."
[2]: https://en.wikipedia.org/wiki/ZIP_%28file_format%29?utm_source=chatgpt.com "ZIP (file format)"
