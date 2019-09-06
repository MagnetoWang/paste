
#include <iostream>
#include <vector>
#include <string>

void SplitString(const std::string& s, std::vector<std::string>& v, const std::string& c)
{
  std::string::size_type pos1, pos2;
  pos2 = s.find(c);
  pos1 = 0;
  while(std::string::npos != pos2)
  {
    v.push_back(s.substr(pos1, pos2-pos1));
 
    pos1 = pos2 + c.size();
    pos2 = s.find(c, pos1);
  }
  if(pos1 != s.length())
    v.push_back(s.substr(pos1));
}
// # "script":"l=label(age)\na=discrete(name)\nb=discrete(age)\nc=continuous(score)",
void MyMapStringToJson(){
    std::string s = "SK_ID_CURR: int32\nTARGET: int32";
    std::vector<std::string> v;
    std::string c = "\n";
    SplitString(s, v, c);
    for (auto e : v) {
        // std::cout << e << std::endl;
        int index = e.find(":");
        std::string name = e.substr(0, index);
        std::string fe_type = e.substr(index + 2);
        // std::string json_type;
        if (fe_type.compare("int32") == 0) {
            fe_type = "int";
        }
        if (fe_type.compare("int64") == 0) {
            fe_type = "long";
        }

        std::cout << "{\"name\": \""<< name << "\",\"type\": \"" + fe_type + "\"}," <<std::endl;
    }
        // for (auto e : v) {
        // // std::cout << e << std::endl;
        // int index = e.find(":");
        // std::string name = e.substr(0, index);
        // std::string type = e.substr(index + 2);
        // std::cout <<  <<std::endl;
    // }
}

int main() {
    MyMapStringToJson();
}