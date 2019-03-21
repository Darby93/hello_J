package linkedlist;

public class LinkedList {
	// 첫번째 노드를 가리키는 필드
    private Node head;
    // 마지막 노드를 가리키는 필드
    private Node tail;
    //리스트의 길이
    private int size = 0;
    
    //노드 생성 클레스
   private class Node{
	   private Object data;
	   private Node next;
	   
	   //생성자
	   public Node(Object input) {
		   //노드의 data에 input값을 넣음
		   this.data = input;
		   //다음 노드를 가리키는 필드의 값은 null 대입
		   this.next = null;
	   }
	   
	   public String toString() {
		   return String.valueOf(this.data);
	   }
   }
 
   //특정 위치의 노드를 찾는 메소드
   Node node(int index) {
	    Node x = head;
    	for (int i = 0; i < index; i++)
	        x = x.next;
	    return x;
	}
   
   //필드의 첫 번째 인덱스에 새로운 노드 생성
   public void addFirst(Object input) {
	   //새로운 노드 생성
	   Node newNode = new Node(input);
	   //newNode.next에 기존 head노드가 가리키고 있던 노드를 가리킬 수 있게 해줌 
	   newNode.next = head;
	 //리스트의 첫번째 노드를 가리키는 head를 newNode를 가리키게 함
	   head = newNode;
	   //리스트의 길이가 늘어났다는 것을 표시
	   size++;
	   //
	   if(head.next == null);{
		   tail = head;
	   }
   }
   
   //필드의 마지막에 새로운 노드 생성
   public void addLast(Object input) {
	   Node newNode = new Node(input);
	   if(size==0) {
		   addFirst(input);
	   }
	   else{
		   tail.next = newNode;
		   tail = newNode;
	   }
	   size++;
   }

   
   public void add(int index, Object input) {
	   if(index==0) {
		   addFirst(input);
	   }
	   else if(index>=size) {
		   addLast(input);
	   }
	   else {
		   Node temp1 = node(index-1);
		   Node temp2 = node(index);
		   
		   Node newNode = new Node(input);
		   temp1.next = newNode;
		   newNode.next = temp2;
		   size++;
		   if(newNode.next==null)
		   {
			   tail = newNode;
		   }
	   }
   }
   
   //노드 전체 데이터 출력
   public String toString() {
	   if(size==0) return "[]";
	   else {
		   Node temp1 = head;
		   String str = "[ ";
		   //마지막 노드 전까지 데이터 출력
		   while(temp1.next!=null) {
			   str+=temp1.data+", ";
			   temp1 = temp1.next;
		   }
		   str += temp1.data + "]";
		   return str;
	   }
   }
   
   //특정 위치 노드의 데이터 탐색
   public Object indexToString(int index) {
	   if(size<=index) {
		   return false;
	   }
	   else {
	   Node temp1 = node(index);
	   return temp1.data;
	   }
   }
   
   //처음 노드 삭제
   public Object firstDelete() {
	   Node temp1 = head;
	   head = temp1.next;
	   
	   Object tempData = temp1.data;
	   temp1=null;
	   size--;
	   
	   return tempData;
   }
   
   //특정 위치 노드 삭제(추가 중)
   public void indexDelete(int index) {
	   Node temp1 = node(index-1);	   
	   temp1.next = node(index+1);
	   temp1 = null;
   }
 }

