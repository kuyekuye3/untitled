import org.w3c.dom.Node;

import java.util.HashMap;
//LRU算法相关的  需要看 需要懂 这次感觉好像没那么难了
public class LRU{
    private HashMap<Integer,Node> cache;


    private Node head,tail;
    private int capacity;

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
         Node(int key,int value){
             this.key = key;
             this.value=value;
    }


    }
    public LRU(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();

        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get( int key){
        if(cache.containsKey(key)){
            return -1;
        }
        Node node=cache.get(key);
        remove(node);
         addToHead(node);
         return node.value;
    }
    //插入
    public  void  put(int key, int value){
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.value=value;
            remove(node);
            addToHead(node);
        }else {
            //不存在新建节点
            Node newNode=new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            //如果超出容量 删除尾部节点
            if(cache.size()>capacity){
                Node removed=removeTail();
                cache.remove(removed.key);
            }
        }
    }
    //将节点添加到头部
    private  void addToHead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next=node;
        head.prev.next=node;
    }
    //从链表删除节点
    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    //删除尾部节点 醉酒没有使用
    private Node removeTail(){
        Node node=tail.prev;
        remove(node);
        return node;
    }
}