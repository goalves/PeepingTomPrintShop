# PeepingTomPrintShop
Basic implementation of a printershop scenario where users need to print their jobs.
The problem in this example was that the printer had a limit of printable job packages per day and at any given time could receive new jobs from its users.
The concurrency problem in this task was solveable using basic Java synchronized routines to prevent race-conditions.
