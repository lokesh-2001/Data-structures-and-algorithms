   cout<<endl<<"Linked List is: "<<endl;
    int count = 0;
    Node *temp=head,*temp1;
    // to find the particular node
    // if found store it in temp1 
    // and if temp1== temp i.e. the last node of loop print the data and exit
    // else continue the iteration and print the items
    cout<<temp->data;
    temp=temp->next;
    while(temp!=NULL){
        if(count==num)
            temp1=temp;
        if(temp1==temp){
            cout<<"->"<<temp->data<<"->"<<temp->next->data<<"->"<<temp->next->next->data;
            return;
        }
        cout<<"->"<<temp->data;
        count++;
        temp=temp->next;
    }
