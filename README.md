# javaEpamUni
Test tasks from the "Java Spring-Summer 2022" program of Epam University.

Description:
In this exercise you need to design two implementations of the Task interface:

CountDownTask:
The constructor of CountDownTask takes a single int value as a parameter. It is the initial value of the countdown. Input value must not be negative. If it is, set zero value.
Each time the execute method is called, this value decrements by one, until it reaches zero. Then the execute method no longer decrements the value and the task is considered finished.
If the task is initialized with zero value, consider it finished right upon creating.
Value of the task is accessible via getter.
CompleteByRequestTask:
Constructor of the CompleteByRequestTask takes no parameters.
Calling execute method on the task does not make it finished until the complete method is called.
Once the complete method is called, the next call to execute makes the task finished. Note that the task is not finished right after calling the complete method. The task finishes only when subsequent call to execute occurs.
Also, you need to implement the TaskCarousel:

A task carousel has a capacity provided as a constructor parameter.
The TaskCarousel has isEmpty method. It returns true if there is no task in the carousel for execution. Returns false otherwise.
The TaskCarousel has isFull method. It returns true if there is no more room in the carousel to add another task. Returns false otherwise.
You may add tasks to the carousel via addTask method. It returns true if the task is accepted and false otherwise. Task may be not accepted due to following reasons:
Task argument is null.
Task is already finished.
Carousel is full.
You may execute tasks in the carousel via execute method.
Each time when this method is invoked, carousel must switch to the next task within and execute it.
Iteration is in circular manner. If there are 4 tasks inside a carousel, then if we call execute method on the carousel 4 times in a row, each task must be executed once.
If the task is finished after execution, remove it from the carousel.
The method returns true if any task was executed. Returns false otherwise.
