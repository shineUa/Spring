package ua.skillsup.javacourse.paintinggallery.model.painting;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.skillsup.javacourse.paintinggallery.model.gallery.PaintingGallery;

import javax.persistence.*;

/**
 * Created by Shine on 12.03.2016.
 */

@Data
@EqualsAndHashCode(of ={"title", "dateMade", "artist", "paintingGallery"})
@ToString(exclude = {"artist"})

@Entity
@Table(name = "Painting")
public class Painting {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "summary")
  private String summary;

  @Column(name = "dateMade", nullable = false)
  private int dateMade;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "artist_id", nullable = false)
  private Artist artist;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "gallery_id")
  private PaintingGallery paintingGallery;

  //------------------------------------------------------------------------------------------------//

  public Long getId() { return id;  }

  public Artist getArtist() { return artist; }

  public void setArtist(Artist artist) { this.artist = artist; }

  public String getTitle() { return title; }

  public void setTitle(String title) {  this.title = title; }

  public int getDateMade() { return dateMade; }

  public void setDateMade(int dateMade) { this.dateMade = dateMade; }

  public String getSummary() { return summary; }

  public void setSummary(String summary) { this.summary = summary; }

  public PaintingGallery getPaintingGallery() { return paintingGallery; }

  public void setPaintingGallery(PaintingGallery paintingGallery) { this.paintingGallery = paintingGallery; }

//  @Override
//  public String toString() {
//    return "Painting{" +
//        "id=" + id +
//        ", title='" + title + "\'" +
//        ", summary='" + summary + "\'" +
//        ", dateMade=" + dateMade +
//        ", artist='" + artist.getName() + "\'" +
//        "}";
//  }
}
