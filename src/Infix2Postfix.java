import java.util.Stack;

public class Infix2Postfix {

	public static String InfixToPostfixConvert(String infixBuffer)
      {
         int priority = 0;
         String postfixBuffer = "";          
 
         Stack<Character> opStack = new Stack<Character>();     //stack to store operand temporarily
 
         for (int i = 0; i < infixBuffer.length(); i++)
         {
            char ch = infixBuffer.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
               if (opStack.size() <= 0)
                  opStack.push(ch);     //opStack’s operand must be at ascending precedence!!!
               else
               {
                  Character chTop = opStack.peek();
                  // compute precedence of top char in opStack
                  if (chTop == '*' || chTop == '/')
                     priority = 1;
                  else
                     priority = 0;
                  if (priority == 1)
                  {
                     postfixBuffer += opStack.pop();
                     i--;          //repeatedly compare top with this char in inputBuffer util opStack empty or 
                     			   //precedence of top is strictly less than ch
                  }
                  else
                  {
                     if (ch == '+' || ch == '-')
                     {
                        postfixBuffer += opStack.pop();
                        opStack.push(ch);		// since precedence of top of opStack is 0, so there must be only one
                     }							// char in opStack since strictly ascending precedence in opStack, so just push ch
                     else
                        opStack.push(ch);
                  }
               }
            }
            else
            {
               postfixBuffer += ch;
            }
         }
         int len = opStack.size();			// any remaining oprand is poped out to result
         for (int j = 0; j < len; j++)
            postfixBuffer += opStack.pop();
         return postfixBuffer;
      }
}
