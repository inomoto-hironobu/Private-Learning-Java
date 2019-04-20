package site.saishin.library.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="count", query="select count(s) from SampleEntity s")
})
public class SampleEntity {
	@Id
	@GeneratedValue
	public Long id;
}
