package ua.skillsup.javacourse.paintinggallery.model.gallery;

import ua.skillsup.javacourse.paintinggallery.model.painting.Painting;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Shine on 12.03.2016.
 */

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class  PaintingGallery {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "owner")
  private String owner;

  @OneToMany(mappedBy = "paintingGallery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Painting> paintings;

  //--------------------------------------------------------------------------------------------------------//

  public long getId() { return id; }

  public String getOwner() { return owner; }

  public void setOwner(String owner) { this.owner = owner; }

  public Set<Painting> getPaintings() { return paintings; }

  public void setPaintings(Set<Painting> paintings) { this.paintings = paintings; }

}
