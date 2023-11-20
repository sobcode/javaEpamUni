# javaEpamUni
Test tasks from the "Java Spring-Summer 2022" program of Epam University.

Description:
DecrementingCarousel is a container, accepting int elements. DecrementingCarousel has a maximum capacity, specified via the constructor. When created, DecrementingCarousel is in accumulating state: you may add elements via the addElement method and can produce a CarouselRun object via the run method. Once the run method is called, DecrementingCarousel is in running state: it refuses adding more elements.

The CarouselRun allows to iterate over elements of the carousel decrementing them one by one with the next method. The next returns the value of the current element:

Then it decreases the current element by one and switches to the next element:

The CarouselRun iterates over elements in the order of their insertion.
When an element is decreased to zero, the CarouselRun will skip it in further iterations. When there are no more elements available for decrementing, the CarouselRun returns -1.

The CarouselRun also has the isFinished method, which indicates, if the carousel has run out of the elements to decrement.
