//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ClimbStarisa{
////    public static  int climbStaris(int n){
////        if(n==1){
////            return 1;}
////        int [] dp=new int[n+1];
////        dp[0]=1;
////        dp[1]=1;
////        for(int i=2;i<=n;i++){
////dp[i]=dp[i-1]+dp[i-2];
////        }
////        return dp[n];
////        }
////public static void main(String [] args){
////    int n=4;
////    int result=climbStaris(n);
////    System.out.println("爬到"+n+"楼梯方法"+result);
//     //   dp[0]=1;
//public static void main(String[] args) {
//    List<String> list = ArrayList.asList("A","b","A");
//    Map<String,Integer> countMap= new HashMap<>();
//    for (String element:list){
//        countMap.put(element,countMap.getOrDefault(element,0)+1);
//    }
//    int maxCount=countMap.values().stream().max(Integer::compareTo).orElse(0);
//
//    List<String> mostFrequentElements=new ArrayList<>();
//    for (Map.Entry<String,Integer> entry:countMap.entrySet()){
//        if(entry.getValue()==maxCount){
//            mostFrequentElements.add(entry.getKey());
//        }
//    }
//    System.out.println("出现最多次数的元素"+maxCount+"次");
//    mostFrequentElements.forEach(System.out::println);
//}
//}
