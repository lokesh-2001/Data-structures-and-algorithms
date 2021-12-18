// // to find the intersection point of 2 linked list in an inverted Y format
// #include <bits/stdc++.h>
// using namespace std;
// class Node
// {
// public:
//     int data;
//     Node *next;
// };
// // INSERT FUNCTION
// void insertBeg(Node **head)
// {
//     Node *new_node = new Node;
//     cout << endl
//          << "enter data: ";
//     cin >> new_node->data;
//     new_node->next = (*head);
//     (*head) = new_node;
// }

// // function to count nodes
// int countNodes(Node *head){
//     Node* temp=head;
//     int count=0;
//     while(temp!=NULL){
//         count++;
//         temp=temp->next;
//     }
//     return count;
// }

// // function to find intersection point of 2 linked list
// // the two linked list intersect at one node and merge together to form a single linked list
// // e.g. linked list-1->>>  16->31->94->14->15->52->96->78->20 
// // e.g. linked list-2->>>  89->42->62->96->78->20 
// //  the two linked list intersect at node having value 96 and the location of node can be found by simply searching it in the linked list

// // Method
// // find the length of two linked lists say n1 and n2
// // if n1>n2 i.e. linked list 1 is longer
// // n= n1-n2 and skip first n nodes from linked list 1 
// // and vice versa if n2>n1 (to basically traverse the linked list of the same size)
// // now traverse the both linked list and check if the data of the current nodes of 2 linked lists is same
// // then return the data of that node else return -1 indicating no intersection point


// int intersectionPoint(Node *head1, Node *head2){
//     Node *temp1=head1,*temp2=head2;
//     Node *temp3=NULL; // new node of the linked list 1
//     Node *temp4=NULL; // new node of the linked list 2

//     int count1,count2;
//     count1=countNodes(head1);
//     count2=countNodes(head2);
//     int countdiff = count1>count2 ? count1-count2 : count2-count1;
//     // if length of linked list is greater than that of second
//     // this block helps to reach the node where the count of that node is equal to the countdiff
//     if(count1>count2){
//         int count;
//         while(temp1!=NULL){
//             if(count==countdiff){
//                 temp3= temp1->next;
//                 break;
//             }
//             else{
//                 temp1=temp3->next;
//                 count++;
//             }
//         }
//     }
//     // linked list 2 is longer
//    else if(count1<count2){
//         int count;
//         while(temp2!=NULL){
//             if(count==countdiff){
//                 temp4= temp2->next;
//                 break;
//             }
//             else{
//                 temp2=temp4->next;
//                 count++;
//             }
//         }
//     }
//     else{
//         temp3=head1;
//         temp4=head2;
//     }
//     // int n = count1>count2 ? count1-countdiff : count2-countdiff;
//     while(temp3->next!=NULL && temp4->next!=NULL){
//         if(temp3->data == temp4->data)
//         {
//             return temp3->data;
//         }
//         temp3=temp3->next;
//         temp4=temp4->next;
//     }
//     return -1;
// }


// // display linked list function
// void display(Node *head)
// {
//     Node *temp = head;
//     if (head != NULL)
//     {
//         cout << temp->data;
//         temp = temp->next;
//         while (temp != NULL)
//         {
//             cout << "->" << temp->data;
//             temp = temp->next;
//         }
//     }
//     else
//     {
//         cout<<"EMPTY!!";
//         return;
//     }
// }

// int main()
// {
//     Node *head1 = NULL; // linked list 1
//     Node *head2 = NULL; // linked list 2
//     int intersection=0;
//     int ch, insertChoice;
//     system("cls");
//     do
//     {
//         cout << endl
//              << "1. Insert in linked list 1";
//         cout << endl
//              << "2. Insert in linked list 2";
//         cout << endl
//              << "3. Find Intersection of point of 2 unsorted linked list";
//         cout << endl
//              << "4. Display";
//         cout << endl
//              << "5. End";
//         cout << endl
//              << "Enter choice: ";
//         cin >> ch;
//         switch (ch)
//         {
//         // Insert function call for linked list 1
//         case 1:
//             // int insertChoice;
//             do
//             {
//                 cout << endl
//                      << "1. INSERT AT BEGINNING";
//                 cout << endl<< "2. EXIT";
//                 cout << endl
//                      << "Enter choice: ";
//                 cin >> insertChoice;
//                 switch (insertChoice)
//                 {
//                 case 1:
//                     insertBeg(&head1);
//                     break;
//                 case 2:
//                     cout << endl
//                          << "EXIT INSERT FUNCTION" << endl;
//                     break;
//                 default:
//                     break;
//                 }
//             } while (insertChoice != 2);
//             break;
//         // insert function for linked list 2
//         case 2:
//             // int insertChoice1;
//             do
//             {
//                 cout << endl
//                      << "1. INSERT AT BEGINNING";
//                 cout << endl<< "2. EXIT";
//                 cout << endl
//                      << "Enter choice: ";
//                 cin >> insertChoice;
//                 switch (insertChoice)
//                 {
//                 case 1:
//                     insertBeg(&head2);
//                     break;
//                 case 2:
//                     cout << endl
//                          << "EXIT INSERT FUNCTION" << endl;
//                     break;
//                 default:
//                     break;
//                 }
//             } while (insertChoice != 2);
//             break;

//         // call the intersectionpoint function 
//         case 3:
//             intersection = intersectionPoint(head1,head2);
//             if(intersection == -1)
//                 cout<<"No interection point";
//             else    
//                 cout<<"Linked list intersects on the node having value : "<<intersection;
//             break;
//         // display function call
//         case 4:
//             cout<<endl<<"Linked List 1: "<<endl;
//             display(head1);
//             cout<<endl<<"Linked List 2: "<<endl;
//             display(head2);
//             break;
//         case 5:
//             cout << "INVALID CHOICE";
//             break;
//         default:
//             cout << "INVALID CHOICE";
//             break;
//         }
//     } while (ch != 5);
// }