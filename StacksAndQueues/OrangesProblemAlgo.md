Algorithm: 
    Create an empty queue Q. 
    
    Find all rotten oranges and enqueue them to Q.
    
    Also, enqueue a delimiter to indicate the beginning of the next time frame.
    
    Run a loop While Q is not empty. 
    
    Do following while delimiter in Q is not reached
        Dequeue an orange from the queue, rot all adjacent oranges. While rotting the adjacent, make sure that the time frame is incremented only once. And the time frame is not incremented if there are no adjacent oranges.
        
        Dequeue the old delimiter and enqueue a new delimiter. The oranges rotten in the previous time frame lie between the two delimiters.