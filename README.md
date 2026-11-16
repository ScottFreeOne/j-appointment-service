# j-appointment-service

# Appointment Service Application

A robust Java-based application designed to manage appointments with strict validation rules for IDs, dates, and descriptions, accompanied by a comprehensive JUnit 5 test suite.

## Project Overview

The project consists of two primary domain classes and their corresponding test suites:

Appointment: Represents an individual appointment containing a unique 10-digit ID, a validated future date (MM-dd-yyyy format), and a description (up to 50 characters).

AppointmentsService: Manages a collection of appointments (AppointmentList), allowing users to add new appointments, delete appointments by ID, and display appointment details.

Class Specifications & Rules

### **Appointment Class (package appointments;)**

appointID: Automatically generated as a 10-digit random string, padded with leading zeros if necessary, and cannot be modified once set.

appointDate: Must be provided in MM-dd-yyyy format, cannot be null, and cannot be set in the past relative to the current system date.

Description: Must not be null or blank, and cannot exceed 50 characters in length.

### **AppointmentsService Class (package appointments;)**

appointList: An ArrayList<Appointment> storing all active appointments.

addAppointment(String potentialDate, String AppointDescription): Creates a new validated Appointment instance and adds it to the list.

deleteAppointment(String appointID): Searches for an appointment by its unique ID and removes it from the list, or prints a message if the ID is not found.

showAppointmentList(): Iterates through the list and prints out the ID, date, and description for each appointment.

### **Test Suite (package tests;)**

The testing package utilizes JUnit 5 to validate all business rules, constructors, exceptions, getters/setters, and service interactions:

AppointmentTest: Tests successful appointment creation, null/blank argument exceptions, date format and past-date validations, description length constraints, and ID property uniqueness and length formatting. Includes manual review tracking comments for state inspection.

AppointmentsServiceTest: Verifies adding appointments to the list, verifying unique ID generation, deleting appointments by ID, and handling missing IDs.

## Getting Started & Running Tests

### **Prerequisites**

Java Development Kit (JDK) 11 or higher

JUnit 5 library configured in your project classpath or build tool (Maven/Gradle)

Execution

Compile the source files under the appointments package and the test files under the tests package.

Run the test classes (AppointmentTest and AppointmentsServiceTest) via your IDE (such as IntelliJ IDEA or Eclipse) or build runner to execute the test suite.

