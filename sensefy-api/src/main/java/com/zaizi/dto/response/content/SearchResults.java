package com.zaizi.dto.response.content;

import org.apache.solr.common.SolrDocument;
import com.zaizi.dto.semantic.EntityType;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Semantic Search AbstractSensefyResponse Content
 * It contains the body for the Semantic Search AbstractSensefyResponse
 *
 * numFound - the number of documents retrieved
 * start" - the starting number of document for pagination
 * entity" - the named entity that eventually drove the query
 * entityType - the entity type that eventually drove the query
 * documents - the documents satisfying the query
 *
 * @author Alessandro Benedetti
 * @since 1.4
 */
@XmlRootElement
@XmlType(propOrder = { "numFound", "start","documents","highlight","collationQuery", "entity", "entityType"})
public class SearchResults
{
    private List<SolrDocument> documents;

    private long numFound;

    private int start;

    private String collationQuery;

    private Map<String, Map<String, List<String>>> highlight;

    private SolrDocument entity;

    private EntityType entityType;


    public SearchResults()
    {
        documents = new ArrayList<SolrDocument>();

    }

    public long getNumFound()
    {
        return numFound;
    }

    public void setNumFound( long numFound )
    {
        this.numFound = numFound;
    }

    public String getCollationQuery()
    {
        return collationQuery;
    }

    public void setCollationQuery( String collationQuery )
    {
        this.collationQuery = collationQuery;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart( int start )
    {
        this.start = start;
    }

    public List<SolrDocument> getDocuments()
    {
        return documents;
    }

    public void setDocuments( List<SolrDocument> documents )
    {
        this.documents = documents;
    }

    public SolrDocument getEntity()
    {
        return entity;
    }

    public void setEntity( SolrDocument entity )
    {
        this.entity = entity;
    }

    public EntityType getEntityType()
    {
        return entityType;
    }

    public void setEntityType( EntityType entityType )
    {
        this.entityType = entityType;
    }

    public Map<String, Map<String, List<String>>> getHighlight()
    {
        return highlight;
    }

    public void setHighlight( Map<String, Map<String, List<String>>> highlight )
    {
        this.highlight = highlight;
    }
}
