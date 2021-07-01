import java.io.*;
import java.net.*;

class ExemploURL {

   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   public static void main(String[] args) {
      String endereco, html;
      int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0, x11 = 0, x12 = 0, x13 = 0, x14 = 0, x15 = 0, x16 = 0, x17 = 0, x18 = 0, x19 = 0, x20 = 0, x21 = 0, x22 = 0, x23 = 0, x24 = 0, x25 = 0, x26 = 0;
      endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      html = getHtml(endereco);

      for(int i = 0; i < html.length(); i++){

         if(html.charAt(i) == 'a'){ x1++; }
         else if(html.charAt(i) == 'e') { x2++; }
         else if(html.charAt(i) == 'i') { x3++; }
         else if(html.charAt(i) == 'o') { x4++; }
         else if(html.charAt(i) == 'u') { x5++; }
         else if(html.charAt(i) == 'á') { x6++; }
         else if(html.charAt(i) == 'é') { x7++; }
         else if(html.charAt(i) == 'í') { x8++; }
         else if(html.charAt(i) == 'ó') { x9++; }
         else if(html.charAt(i) == 'ú') { x10++; }
         else if(html.charAt(i) == 'à') { x11++; }
         else if(html.charAt(i) == 'è') { x12++; }
         else if(html.charAt(i) == 'ì') { x13++; }
         else if(html.charAt(i) == 'ò') { x14++; }
         else if(html.charAt(i) == 'ù') { x15++; }
         else if(html.charAt(i) == 'ã') { x16++; }
         else if(html.charAt(i) == 'õ') { x17++; }
         else if(html.charAt(i) == 'â') { x18++; }
         else if(html.charAt(i) == 'ê') { x19++; }
         else if(html.charAt(i) == 'î') { x20++; }
         else if(html.charAt(i) == 'ô') { x21++; }
         else if(html.charAt(i) == 'û') { x22++; }
         else if(html.charAt(i) >= 'b' && html.charAt(i) <= 'd' || html.charAt(i) >= 'f' && html.charAt(i) <= 'h' || html.charAt(i) >= 'j' && html.charAt(i) <= 'n' || html.charAt(i) >= 'p' && html.charAt(i) <= 't' || html.charAt(i) >= 'v' && html.charAt(i) <= 'z') { x23++; }
         /*else if(html.charAt(i) == '') { x24++; }
         else if(html.charAt(i) == '') { x25++; }
         else if(html.charAt(i) == '') { x26++; }*/
      }

      System.out.println("a("+x1+") e("+x2+") i("+x3+") o("+x4+") u("+x5+") á("+x6+") é("+x7+") í("+x8+") ó("+x9+") ú("+x10+") à("+x11+") è("+x12+") ì("+x13+") ò("+x14+") ù("+x15+") ã("+x16+") õ("+x17+") â("+x18+") ê("+x19+") î("+x20+") ô("+x21+") û("+x22+") consoante("+x23+")");
   }
}
