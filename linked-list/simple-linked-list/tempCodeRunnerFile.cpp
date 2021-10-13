 SegregateOddAndEven(Node **head){
    Node *end = *head;
    Node *prev = NULL;
    Node *curr = *head;
    
    // get last node 
    while (end->next != NULL)
        end = end->next;
 
    Node *new_end = end;
 
    // loop till first even node or till end of linked list
    while (curr->data % 2 != 0 && curr != end)
    {
        new_end->next = c