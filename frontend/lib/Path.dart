import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';

class Path{
  String id = "";
  String text = "";

  Path({
    required this.id,
    required this.text,
  });

  Path.fromJson(Map<String, dynamic> json){
      id = json['id'];
      text = json['text'];
  }
}

////////////////////////////////////////////////////////////////////////////////
//                          Get - single path                                 //
////////////////////////////////////////////////////////////////////////////////

Future<Path> fetchPath() async {
  var url = Uri.parse("http://localhost:8080/1");
  final response = await http.get(url);
  Map<String, dynamic> decodedResponseBody = json.decode(response.body);

  if(response.statusCode == 200){
    var responseBody = response.body;
    print("200 ok - $responseBody");
    Path returnVal = Path(
        id: decodedResponseBody['id'],
        text: decodedResponseBody['text']
    );

    return returnVal;
  }
  else{
    throw Exception("Failed to retrieve paths");
  }
}

/** retrieves all xCenter paths from the backend
 *
 */
Future<List<Path>> fetchAllPaths() async {
  List<Path> pathList;
  var url = Uri.parse("http://localhost:8080/");
  final response = await http.get(url);
  pathList = (json.decode(response.body) as List).map((i) => Path.fromJson(i)).toList();

  return pathList;
}

