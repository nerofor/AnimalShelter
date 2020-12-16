package uni.eszterhazy.animalshelter.exception;

public class SkillNotFound extends Throwable{
    public SkillNotFound(String id) {
        super(id);
    }
}