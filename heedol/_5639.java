import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5639 {

    static class Tree {
        Node rootNode;

        void addNode(int value) {
            // 루트 노드가 존재하지 않다면
            if (this.rootNode == null) {
                this.rootNode = new Node(value); // 루트 노드 세팅
                return;
            }

            // 루트 노드가 존재한다면
            Node currentNode = this.rootNode;

            while (true) {
                if (value < currentNode.value) { // 현재 값이 루트 노드의 키값보다 작다면
                    // 왼쪽 자식이 없다면 값 세팅 후 종료
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Node(value);
                        return;
                    }
                    // 왼쪽 자식이 있다면 이동 탐색
                    currentNode = currentNode.leftChild;
                } else { // 현재 값이 루트 노드의 키값보다 작다면
                    // 오른쪽 자식이 없다면 값 세팅 후 종료
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Node(value);
                        return;
                    }
                    // 오른쪽 자식이 있다면 이동 탐색
                    currentNode = currentNode.rightChild;
                }
            }
        }

        // 후위 순회
        void postOrder(Node node, StringBuilder sb) {
            // 왼쪽 자식이 있다면
            if (node.leftChild != null) {
                this.postOrder(node.leftChild, sb); // 왼쪽 탐색
            }

            // 오른쪽 자식이 있다면
            if (node.rightChild != null) {
                this.postOrder(node.rightChild, sb); // 오른쪽 탐색
            }
            sb.append(node.value).append("\n"); // 자기 자신 값 기록
        }

        // 후위 순회 결과값 반환
        String getPostOrderResult() {
            StringBuilder sb = new StringBuilder();
            this.postOrder(this.rootNode, sb);
            return sb.toString();
        }
    }

    static class Node {
        int value;
        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Tree tree = new Tree();

        while (true) {
            String inputData = br.readLine();
            if (inputData == null || inputData.equals("")) {
                break;
            }

            tree.addNode(Integer.parseInt(inputData));
        }

        System.out.print(tree.getPostOrderResult());
    }
}
