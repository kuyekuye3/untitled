//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.*;
//import java.util.stream.Collectors;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//class Result {
//
//    // 用于存储文章名称和评论数的映射
//    static class Article {
//        String name;
//        int numComments;
//
//        Article(String name, int numComments) {
//            this.name = name;
//            this.numComments = numComments;
//        }
//    }
//
//    public static List<String> topArticles(int limit) {
//        List<Article> articles = new ArrayList<>();
//        int page = 1;
//        int totalPages = 1;
//
//        try {
//            // 遍历所有页面
//            while (page <= totalPages) {
//                URL url = new URL("https://jsonmock.hackerrank.com/api/articles?page=" + page);
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("GET");
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder response = new StringBuilder();
//                String inputLine;
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                connection.disconnect();
//
//                // 解析 JSON
//                JSONObject jsonResponse = new JSONObject(response.toString());
//                System.out.println("Debug: Page " + page + " Response: " + jsonResponse.toString()); // 调试日志
//                totalPages = jsonResponse.getInt("total_pages");
//                JSONArray data = jsonResponse.getJSONArray("data");
//
//                // 提取文章名称和评论数
//                for (int i = 0; i < data.length(); i++) {
//                    JSONObject article = data.getJSONObject(i);
//                    String storyTitle = article.isNull("story_title") ? null : article.getString("story_title");
//                    String title = article.isNull("title") ? null : article.getString("title");
//                    String articleName = (storyTitle != null) ? storyTitle : (title != null) ? title : null;
//                    // 如果 num_comments 为 null，则默认为 0
//                    int numComments = article.isNull("num_comments") ? 0 : article.getInt("num_comments");
//
//                    if (articleName != null) {
//                        articles.add(new Article(articleName, numComments));
//                        System.out.println("Debug: Added article: " + articleName + " with " + numComments + " comments"); // 调试日志
//                    }
//                }
//
//                page++;
//            }
//
//            // 按评论数和名称排序
//            articles.sort((a, b) -> {
//                if (a.numComments != b.numComments) {
//                    return Integer.compare(b.numComments, a.numComments); // 按评论数降序
//                } else {
//                    return b.name.compareTo(a.name); // 按名称降序
//                }
//            });
//
//            // 提取前 limit 个文章名称
//            List<String> result = articles.stream()
//                    .map(article -> article.name)
//                    .limit(Math.max(0, limit)) // 确保 limit 非负
//                    .collect(Collectors.toList());
//
//            System.out.println("Debug: Final result size: " + result.size()); // 调试日志
//            return result;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int limit = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> result = Result.topArticles(limit);
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(Collectors.joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}