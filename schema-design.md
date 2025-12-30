# Smart Clinic Management System – Schema Design

## MySQL Database Design

MySQL is used to store structured and relational data that is critical to clinic operations.

### Table: patients
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- email: VARCHAR(100), Unique, Not Null
- phone: VARCHAR(15), Not Null
- date_of_birth: DATE
- created_at: TIMESTAMP, Default CURRENT_TIMESTAMP

### Table: doctors
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- specialization: VARCHAR(100), Not Null
- email: VARCHAR(100), Unique, Not Null
- phone: VARCHAR(15)
- available_from: TIME
- available_to: TIME

### Table: admin
- id: INT, Primary Key, Auto Increment
- username: VARCHAR(50), Unique, Not Null
- password: VARCHAR(255), Not Null
- email: VARCHAR(100), Unique

### Table: appointments
- id: INT, Primary Key, Auto Increment
- patient_id: INT, Foreign Key → patients(id)
- doctor_id: INT, Foreign Key → doctors(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

Notes:
- A patient can have multiple appointments
- A doctor cannot have overlapping appointments
- Appointment history should be retained even if a patient account is inactive


## MongoDB Collection Design

MongoDB is used for flexible, unstructured, or optional data that may evolve over time.

### Collection: prescriptions

Prescriptions are stored in MongoDB because they may include flexible notes, metadata, and nested structures.

```json
{
  "_id": "ObjectId('64abc123456')",
  "patientId": 12,
  "doctorId": 5,
  "appointmentId": 45,
  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg",
      "frequency": "Twice a day"
    },
    {
      "name": "Vitamin C",
      "dosage": "250mg",
      "frequency": "Once a day"
    }
  ],
  "doctorNotes": "Take medicines after food",
  "refillCount": 2,
  "createdAt": "2025-01-15T10:30:00Z",
  "metadata": {
    "pharmacy": "Apollo Pharmacy",
    "tags": ["fever", "general"]
  }
}
