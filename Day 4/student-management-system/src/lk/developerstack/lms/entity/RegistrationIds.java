package lk.developerstack.lms.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistrationIds implements Serializable {
    private static final long serialVersionUID = 248352498869652930L;

    @Column(name = "student_id")
    private long studentId;

    @Column(name = "program_id")
    private long programId;

    public RegistrationIds() {
    }

    public RegistrationIds(long studentId, long programId) {
        this.studentId = studentId;
        this.programId = programId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegistrationIds)) return false;
        RegistrationIds that = (RegistrationIds) o;
        return studentId == that.studentId && programId == that.programId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, programId);
    }
}
