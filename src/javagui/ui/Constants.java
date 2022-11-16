package ui;
public class Constants {

    public static StringBuilder sb = new StringBuilder( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Ontology xmlns=\"http://www.w3.org/2002/07/owl#\"\n" +
            "     xml:base=\"http://www.semanticweb.org/52380/ontologies/2020/11/untitled-ontology-4\"\n" +
            "     xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
            "     xmlns:xml=\"http://www.w3.org/XML/1998/namespace\"\n" +
            "     xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\"\n" +
            "     xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n" +
            "     ontologyIRI=\"http://www.semanticweb.org/52380/ontologies/2020/11/untitled-ontology-4\">\n" +
            "    <Prefix name=\"\" IRI=\"http://www.semanticweb.org/52380/ontologies/2020/11/untitled-ontology-4\"/>\n" +
            "    <Prefix name=\"owl\" IRI=\"http://www.w3.org/2002/07/owl#\"/>\n" +
            "    <Prefix name=\"rdf\" IRI=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"/>\n" +
            "    <Prefix name=\"xml\" IRI=\"http://www.w3.org/XML/1998/namespace\"/>\n" +
            "    <Prefix name=\"xsd\" IRI=\"http://www.w3.org/2001/XMLSchema#\"/>\n" +
            "    <Prefix name=\"rdfs\" IRI=\"http://www.w3.org/2000/01/rdf-schema#\"/>");



    static String classSample = "    <Declaration>\n" +
            "        <Class IRI=\"#{0}\"/>\n" +
            "    </Declaration>";


    static String subClassOf = "    <SubClassOf>\n" +
            "        <Class IRI=\"#{0}\"/>\n" +
            "        <Class IRI=\"#{1}\"/>\n" +
            "    </SubClassOf>";


    static String namedIndividual = "    <Declaration>\n" +
            "        <NamedIndividual IRI=\"#{0}\"/>\n" +
            "    </Declaration>";

    static String negativeDataPropertyAssertion = "<NegativeDataPropertyAssertion>\n" +
            "        <DataProperty IRI=\"#{0}\"/>\n" +
            "        <NamedIndividual IRI=\"#{1}\"/>\n" +
            "        <Literal datatypeIRI=\"http://www.w3.org/2001/XMLSchema#integer\">{2}</Literal>\n" +
            "    </NegativeDataPropertyAssertion>";

    static String objectProperty = "    <Declaration>\n" +
            "        <ObjectProperty IRI=\"#{0}\"/>\n" +
            "    </Declaration>";


    static String objectPropertyDomain= "    <ObjectPropertyDomain>\n" +
            "        <ObjectProperty IRI=\"#{0}\"/>\n" +
            "        <Class IRI=\"#{1}\"/>\n" +
            "    </ObjectPropertyDomain>";


    static String objectPropertyRange ="    <ObjectPropertyRange>\n" +
            "        <ObjectProperty IRI=\"#{0}\"/>\n" +
            "        <Class IRI=\"#{1}\"/>\n" +
            "    </ObjectPropertyRange>";


    static String objectPropertyAssertion = "    <ObjectPropertyAssertion>\n" +
            "        <ObjectProperty IRI=\"#{0}\"/>\n" +
            "        <NamedIndividual IRI=\"#{1}\"/>\n" +
            "        <NamedIndividual IRI=\"#{2}\"/>\n" +
            "    </ObjectPropertyAssertion>";


    static String dataPropertyDomain = "    <DataPropertyDomain>\n" +
            "        <DataProperty abbreviatedIRI=\"owl:{0}\"/>\n" +
            "        <Class IRI=\"#{1}\"/>\n" +
            "    </DataPropertyDomain>";
}

