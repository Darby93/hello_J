package linkedlist;
// LinkedList 객체
public class MyLinkedList {	
	
	private Node header;	// list의 header
	private int size;		// list의 size
	
	// 리스트의 header, size 초기화
	public MyLinkedList(){
		header = new Node(null);	
		size = 0;
	}
	
	// 노드의 데이터 리턴
	public Object getNodeData(int index){
	       return getNode(index).getData();
	}
	// 노드 getter
	private Node getNode(int index){
		
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}
		
		Node node = header.getNextNode();
		for(int i =0; i < index; i++){
			node = node.getNextNode();
		}
		
		return node;
	}
	
	
	/*public Object getFirst(){
		return get(0);
	}*/
	
	
	public int getNodeIndex(Object obj){
		
		if(size<=0){
			return -1;
		}
		
		int index=0;
		Node node = header.getNextNode();
		Object nodeData = node.getData();
		
		
		while(!obj.equals(nodeData)){
			node = node.getNextNode();
			
			if(node==null){
				return -1;
			}
			
			nodeData = node.getData();
			index++;
		}
		
		return index;
	}
	
	// ----------------------------------------------- 삽입
	// 리스트 처음에 삽입
	public void addFirst(Object data){
		
		Node newNode = new Node(data);
		newNode.setNextNode(header.getNextNode());
		header.setNextNode(newNode);
		size++;
		
	}
	
	// 리스트 중간에 삽입
	public void addAtmiddle(int index, Object data){
		
		if(index==0){		// index 가 0 이면
			addFirst(data);	// 리스트 처음에 삽입
			return;			// 
		}
		
		Node previous = getNode(index-1);
		Node nextnode = previous.getNextNode();
		
		Node newNode = new Node(data);
		previous.setNextNode(newNode);
		newNode.setNextNode(nextnode);
		size++;
	}
	
	// 리스트 끝에 삽입
	public void addLast(Object data){
		addAtmiddle(size, data);
	}
	
	
	/*// 끝에 넣기
	public void add(Object data){
		addLast(data);
	}*/
	
	// ----------------------------------------------- 삭제
	// 리스트 처음꺼 삭제
	public Object removeFirst(){
		
		Node firstNode = getNode(0);
		header.setNextNode(firstNode.getNextNode()); 
		size--;
		return firstNode.getData();
		
	}
	
	// 리스트 중간꺼 삭제
	public Object removeAtmiddle(int index){
		
		if(index<0 || index>=size){
			
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
		
		}else if(index ==0){
			
			return removeFirst();
		
		}
		
		Node previous = getNode(index-1);
		Node removeNode = previous.getNextNode();
		Node next = removeNode.getNextNode();
		previous.setNextNode(next);
		size--;
		
		return removeNode.getData();
	}
	
	//????? 데이터를 입력해서 삭제 
	public void removeByData(Object data){
		
		int nodeIndex = getNodeIndex(data);
		
		if(nodeIndex == -1){
			System.out.println("no data");
			
		}else{
			removeAtmiddle(nodeIndex);
			
		}
	}
	
	// 리스트 마지막꺼 삭제
	public Object removeLast(){
		return removeAtmiddle(size-1);
	}
	
	
	public int getListsize(){
		return size;
	}
	
	
	public String toString(){
		
		StringBuffer result = new StringBuffer("[");
		Node node = header.getNextNode();
		
		if(node!=null){
			result.append(node.getData());
			node = node.getNextNode();
			
			while(node != null){
				result.append(", ");
				result.append(node.getData());
				node = node.getNextNode();
			}
		}
		
		result.append("]");
		return result.toString();
	}

}
