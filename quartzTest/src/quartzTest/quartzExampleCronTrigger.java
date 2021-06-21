package quartzTest;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class quartzExampleCronTrigger {
	public static void main(String[] args) {
		new quartzExampleCronTrigger();
	}
	
	private SchedulerFactory schedFact;
	private Scheduler sched;
	
	public quartzExampleCronTrigger() {
		try {
			schedFact = new StdSchedulerFactory();
			sched = schedFact.getScheduler();
			sched.start();
			
			JobDetail job1 = new JobDetail("job1", "group1", TestJob1.class);
			
			CronTrigger trigger1 = new CronTrigger("trigger1", "group1", "0 * * * * ?");
			sched.scheduleJob(job1, trigger1);
			
			JobDetail job2 = new JobDetail("job2", "group2", TestJob2.class);
			CronTrigger trigger2 = new CronTrigger("trigger2","group2", "30 * * * * ?");
			sched.scheduleJob(job2, trigger2);
		} catch (Exception e) {
		}
	}
}
