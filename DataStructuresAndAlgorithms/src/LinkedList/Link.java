
package LinkedList;


public class Link{
    
    public String bookName;
    
    public int millionSold;
    
    public Link next;
    
    public Link(String bookName, int millionSold){
        
        this.bookName = bookName;
        this.millionSold = millionSold;
        
    }
    
    public void display(){
        System.out.println(bookName + ": " + millionSold + ",000,000");
    }
    
    public String toString(){
        
        return bookName;
    }
    
    public static void main(String[] args){
        LinkList ll = new LinkList();
        ll.insertFirstLink("Game Of Thrones", 1);
        ll.insertFirstLink("Dance With The Dragons", 2);
        ll.insertFirstLink("Crows", 2);
        ll.removeFirst();
        ll.removeLink("Game Of Thrones");
        ll.display();
    }
}

class LinkList{
    
    public Link firstLink;
    
    LinkList(){
        firstLink = null;
    }
    
    public boolean isEmpty(){
        
        return(firstLink == null);
        
    }
    
    public void insertFirstLink(String bookName, int millionSold){
        
        Link newLink = new Link(bookName, millionSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }
    
    public Link removeFirst(){
        Link linkReference = firstLink;
        if(!isEmpty()){
            firstLink = firstLink.next;
        }else System.out.println("Empty LinkedList");
        
        return linkReference;
    }
    
    public void display(){
        Link theLink = firstLink;
        
        while(theLink!=null){
            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }
    
    public Link find(String bookName){
        Link theLink = firstLink;
        
        if(!isEmpty()){
            while(theLink.bookName != bookName){
                if(theLink.next == null){
                    return null;
                }else{
                    theLink = theLink.next;
                }
            }
        }else{
            System.out.println("Empty LinkedList");
        }
        
        return theLink;
    }
    
    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;
        
        while(currentLink.bookName != bookName){
            if(currentLink.next == null){
                return null;
            }else{
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        
        if(currentLink == firstLink){
            firstLink = firstLink.next;
        }else{
            previousLink.next = currentLink;
        }
        return currentLink;
    }
}
