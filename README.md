### Task:
#### “Please write a program in your preferred language that will send out emails to recipients from a huge list (1 Mio entries) in a performant way. You do not need to send real emails but just fake the email sending by waiting for half a second.”

**Performance** can have different meanings such as most resource efficient or fastest possible or sometimes being a background task to not bother other tasks.

Here where no further data provided.
I have assumed that Emails are in a list and number of Threads are 4.  
To have a better performance and implementation more detail is needed.

It is possible to read addresses from a database in every thread.

This was my first attempt to implement a multi thread and mailer service. it runs and thank for such an interesting task. 

set username and password in class Mailer and start the project.
--- downloading dependencies using maven might be necessary. ---