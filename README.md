# TRMS_Proj
Tuition Reimbursement Management System

## About
### Purpose
This is a full stack web application designed to handle the tuition reimbursement program for a company. This tuition reimbursement program allows for an employee to 
submit a tuition reimbursement form. This form requests reimbursement for a class, seminar, certification, or several other choices of learning that apply to the employees
job. For this form to be approved the employees supervisor, department head, and the company Benco all must approve the request. Upon approval the employee is allowed
reimbursement provided a passing grade or a presentation are submitted. The Benco will once again review to ensure the requirements were met and then approve or deny the
final request based on that. If approved the employee is reimbursed the cost of the course according to the coverage percentage, otherwise the employee is reimbursed
nothing.

### How it works
The application works by first having every employee eligible for tuition reimbursement through the company in a database accessed by the app as well as their superiors.
An employee that exists in this database may log in through the login page, which is also the landing page when this site is first visited. If someone tries to access
other pages of the app before logging in, they will be sent to the login page. On the login page the employee will input their username and password and be redirected to
their respective dashboard if the credentials exist and are entered correctly.

On the employee dashboard, it will display the basic info of the employee, all of the tuition reimbursement forms they had sent for a request, a button to create a new
request form and if the employee is a supervisor to anyone, it will have a list of the employees beneath them. A department head will have a list of all employees in 
their department, and the Benco will have all of the employees in the system as they have to review every form submitted. If an employee clicks on an existing form they
will be brought to the view form page.

This page will populate with all of the info of the form, as well as a delete button for an employee to remove a submitted request. If the form has been approved past the
initial stage of reviews, a new field will open allowing the employee to submit their final grade for the course once recieved. 

If the employee clicks on the create new form button on their dashboard it will redirect to a new page where they can submit all the information for the event they are
requesting reimbursement for. Once submitted they will be redirected back to their dashboard and the form will be added in the database.

If an employee of supervisor status or higher is logged in, they may click on an employee on the list of their subordinates on the dashboard to be redirected to a page
to see that specific employees requests. This new page will have a table for forms awaiting initial review, completed reviews, and if the employee is the Benco it will
show forms awaiting a final review. The superior may click on any of these forms to see all the information about them and the event the employee requested reimbursement
for. If denied at any level, this ends the review process for that form and it is added to the completed forms list. If it gets approved it awaits the other approvals 
before being moved to the final approvals list. If the Benco selects a form from the final approval list, the employee must have submitted a final grade before the Benco
is given the option to approve or deny the request based on the grade. If the final approval is approved, the balance of the employees alloted reimbursement is changed to
reflect the change.

### Structure
This was strucured using a layered design pattern along with a DAO design patter. Starting at the database, going to the repositories that utilized the DAO design pattern,
then to the services layer, controller layer, servlet layer, and finally the view layer was HTML files using css styling and JavaScript to create AJAX calls to the
backend.



