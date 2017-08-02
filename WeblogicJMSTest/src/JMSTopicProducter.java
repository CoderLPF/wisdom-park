import java.util.Properties;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;


public class JMSTopicProducter {
	public void send(){         
		TopicConnectionFactory tcf = null;          
		Topic topic = null;                 
		try {              
			String m_url="t3://localhost:7001";          
			Properties h = new Properties();  
			h.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");       
			h.put(Context.PROVIDER_URL, m_url);              
			Context jndiContext = new InitialContext(h);             
			tcf = (TopicConnectionFactory)               
			jndiContext.lookup("jms/ConnectionFactory");             
			//�õ�topic              
			topic = (Topic) jndiContext.lookup("jms/Topic");             
			TopicConnection tc = null;             
			//�õ�jms�����ӹ���             
			tc = tcf.createTopicConnection();             
			//����jms�ĻỰ             
			TopicSession ts = tc.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);              
			// �����ض��ĻỰ������Ϣ��������               
			TopicPublisher tp = ts.createPublisher(topic);             
			//������Ϣ          
			TextMessage textMessage =  ts.createTextMessage();             
			textMessage.setText("hello JMS");             
			//������Ϣ              
			tp.publish(textMessage);              
			System.out.println("��Ϣ��topic����success");            
		} catch (Exception nameEx) {             
			System.err.println(nameEx.toString());           
		}             
	}     
	
	public static void main(String []args){    
		new JMSTopicProducter().send();    
	}
}
