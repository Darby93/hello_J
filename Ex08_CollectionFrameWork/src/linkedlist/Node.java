package linkedlist;

// list의 node 클래스
public class Node{		
		
		private Object data;	// node의 data
		private Node nextNode;	// node의 다음 노드(연결)
		
		public Node(Object data){		// 노드의 data와 다음 노드 초기화
			
			this.data = data;
			this.nextNode = null;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
	
	
}