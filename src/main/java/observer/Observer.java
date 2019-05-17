package observer;

import java.util.ArrayList;

public class Observer {

    private ArrayList<ISubject> subjects;

    public Observer() {
        this.subjects = new ArrayList<>();
    }

    /**
     * Attempt to register new subject that will listen
     * @param subject
     * @return true if it does not already exist and was added successfuly. false if it already exists and did not add
     */
    public boolean register(ISubject subject){
        if(this.subjects.contains(subject)) return false;
        this.subjects.add(subject);
        return true;
    }

    /**
     * Remove a given subject
     * @param subject
     * @return true if it was found and removed, false if it was not found
     */
    public boolean unregister(ISubject subject){
        return this.subjects.remove(subject);
    }

    /**
     * Removes all subjects
     */
    public void clear(){
        this.subjects.clear();
    }

    /**
     *
     * @return the number of subjects listening
     */
    public int getSubjectCount(){
        return this.subjects.size();
    }

    /**
     * Notify all subjects that are listening
     * @param message some message to pass to subject
     * @param object some payload to send to subjects
     */
    public void notify(String message, Object object){
        for (ISubject subject: this.subjects
             ) {
            subject.onNotify(message, object);
        }
    }
}
