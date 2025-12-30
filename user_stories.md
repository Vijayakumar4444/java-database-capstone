# User Story Template
**Title:**
_As a [user role], I want [feature/goal], so that [reason]._
**Acceptance Criteria:**
1. [Criteria 1]
2. [Criteria 2]
3. [Criteria 3]
**Priority:** [High/Medium/Low]
**Story Points:** [Estimated Effort in Points]
**Notes:**
- [Additional information or edge cases]
- # Admin User Stories

**Title:** Admin Login  
_As an admin, I want to log into the portal using my username and password, so that I can manage the system securely._

**Acceptance Criteria:**  
1. Admin can enter valid credentials  
2. Admin is redirected to dashboard  
3. Invalid login shows error  

**Priority:** High  
**Story Points:** 3  
**Notes:** Session timeout required

---

**Title:** Admin Logout  
_As an admin, I want to log out of the portal, so that system access is protected._

**Acceptance Criteria:**  
1. Logout button is visible  
2. Session is destroyed  
3. User redirected to login page  

**Priority:** Medium  
**Story Points:** 2  
**Notes:** None

---

**Title:** Add Doctor  
_As an admin, I want to add doctors to the portal, so that patients can book appointments._

**Acceptance Criteria:**  
1. Admin can enter doctor details  
2. Doctor profile is saved  
3. Doctor appears in doctor list  

**Priority:** High  
**Story Points:** 5  
**Notes:** Validate email and specialization

---

**Title:** Delete Doctor  
_As an admin, I want to delete a doctor profile, so that inactive doctors are removed._

**Acceptance Criteria:**  
1. Admin can select doctor  
2. Confirmation before delete  
3. Doctor is removed from system  

**Priority:** Medium  
**Story Points:** 3  
**Notes:** Do not delete doctors with active appointments

---

**Title:** View Appointment Statistics  
_As an admin, I want to run a MySQL stored procedure, so that I can view monthly appointment statistics._

**Acceptance Criteria:**  
1. Stored procedure executes successfully  
2. Monthly count is displayed  
3. Data is accurate  

**Priority:** Low  
**Story Points:** 5 
# Patient User Stories

**Title:** View Doctors List  
_As a patient, I want to view doctors without logging in, so that I can explore options._

**Acceptance Criteria:**  
1. Doctor list is visible  
2. No login required  
3. Basic details shown  

**Priority:** Medium  
**Story Points:** 2  
**Notes:** Read-only access

---

**Title:** Patient Registration  
_As a patient, I want to sign up using email and password, so that I can book appointments._

**Acceptance Criteria:**  
1. Email and password accepted  
2. Account created successfully  
3. Login enabled after signup  

**Priority:** High  
**Story Points:** 3  
**Notes:** Email validation required

---

**Title:** Patient Login  
_As a patient, I want to log into the portal, so that I can manage my bookings._

**Acceptance Criteria:**  
1. Login with email and password  
2. Dashboard shown  
3. Error on invalid credentials  

**Priority:** High  
**Story Points:** 3  
**Notes:** None

---

**Title:** Book Appointment  
_As a patient, I want to book a one-hour appointment, so that I can consult a doctor._

**Acceptance Criteria:**  
1. Available slots shown  
2. Appointment booked successfully  
3. Confirmation displayed  

**Priority:** High  
**Story Points:** 5  
**Notes:** Prevent double booking

---

**Title:** View Upcoming Appointments  
_As a patient, I want to view upcoming appointments, so that I can prepare in advance._

**Acceptance Criteria:**  
1. Appointment list shown  
2. Date and time visible  
3. Doctor name included  

**Priority:** Medium  
**Story Points:** 2  
**Notes:** Sort by date
# Doctor User Stories

**Title:** Doctor Login  
_As a doctor, I want to log into the portal, so that I can manage my appointments._

**Acceptance Criteria:**  
1. Doctor can log in  
2. Dashboard displayed  
3. Invalid login shows error  

**Priority:** High  
**Story Points:** 3  
**Notes:** Secure authentication

---

**Title:** Doctor Logout  
_As a doctor, I want to log out, so that my data remains secure._

**Acceptance Criteria:**  
1. Logout button works  
2. Session cleared  
3. Redirect to login page  

**Priority:** Medium  
**Story Points:** 2  
**Notes:** None

---

**Title:** View Appointment Calendar  
_As a doctor, I want to view my appointment calendar, so that I stay organized._

**Acceptance Criteria:**  
1. Calendar view available  
2. Appointments shown by date  
3. Easy navigation  

**Priority:** High  
**Story Points:** 4  
**Notes:** Monthly view preferred

---

**Title:** Mark Unavailability  
_As a doctor, I want to mark unavailable slots, so that patients book only available times._

**Acceptance Criteria:**  
1. Unavailable slots selectable  
2. Slots blocked for booking  
3. Changes saved  

**Priority:** High  
**Story Points:** 4  
**Notes:** Future dates only

---

**Title:** Update Doctor Profile  
_As a doctor, I want to update my profile, so that patients see correct information._

**Acceptance Criteria:**  
1. Profile editable  
2. Changes saved  
3. Updated details visible  

**Priority:** Medium  
**Story Points:** 3  
**Notes:** Contact and specialization only

**Notes:** CLI execution required

