/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.enterprise.config.serverbeans;

import org.glassfish.api.admin.config.ReferenceContainer;
import org.jvnet.hk2.config.types.PropertyBag;
import org.glassfish.api.admin.config.ApplicationName;
import org.glassfish.api.admin.config.PropertiesDesc;
import org.jvnet.hk2.config.types.Property;
import org.glassfish.api.admin.config.PropertyDesc;
import org.glassfish.quality.ToDo;
import org.jvnet.hk2.component.Injectable;
import org.jvnet.hk2.config.Attribute;
import org.jvnet.hk2.config.ConfigBeanProxy;
import org.jvnet.hk2.config.Configured;
import org.jvnet.hk2.config.DuckTyped;
import org.jvnet.hk2.config.Element;
import com.sun.enterprise.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.beans.PropertyVetoException;
import java.util.*;


@Configured
/**
 * Top level Domain Element that includes applications, resources, configs,
 * servers, clusters and node-agents, load balancer configurations and load
 * balancers. node-agents and load balancers are SE/EE related entities only.
 *
 */
public interface Domain extends ConfigBeanProxy, Injectable, PropertyBag, SystemPropertyBag  {

    /**
     * Gets the value of the applicationRoot property.
     *
     * For PE this defines the location where applications are deployed
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute
    String getApplicationRoot();

    /**
     * Sets the value of the applicationRoot property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setApplicationRoot(String value) throws PropertyVetoException;

    /**
     * Gets the value of the logRoot property.
     *
     * Specifies where the server instance's log files are kept, including
     * HTTP access logs, server logs, and transaction logs.
     * Default is $INSTANCE-ROOT/logs
     * 
     * @return possible object is
     *         {@link String }
     */
    @Attribute
    String getLogRoot();

    /**
     * Sets the value of the logRoot property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setLogRoot(String value) throws PropertyVetoException;

    /**
     * Gets the value of the locale property.
     *
     * @return possible object is
     *         {@link String }
     */
    @Attribute
    String getLocale();

    /**
     * Sets the value of the locale property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    void setLocale(String value) throws PropertyVetoException;

    /**
     * Gets the value of the version property. It is read-only.
     *
     * Tools are not to depend on this property. It is only for reference.
     *
     * @return String representing version of the Domain.
     */
    @Attribute
    String getVersion();

    /**
     * Gets the value of the applications property.
     *
     * @return possible object is
     *         {@link Applications }
     */
    @Element
    @NotNull
    Applications getApplications();

    /**
     * Sets the value of the system-applications property.
     *
     * @param value allowed object is
     *              {@link Applications }
     */
    void setApplications(Applications value) throws PropertyVetoException;

    @Element
    @NotNull
    SystemApplications getSystemApplications();

    /**
     * Sets the value of the system-applications property.
     *
     * @param value allowed object is
     *              {@link Applications }
     */
    void setSystemApplications(SystemApplications value) throws PropertyVetoException;
    /**
     * Gets the value of the resources property.
     *
     * @return possible object is
     *         {@link Resources }
     */
    @Element
    Resources getResources();

    /**
     * Sets the value of the resources property.
     *
     * @param value allowed object is
     *              {@link Resources }
     */
    void setResources(Resources value) throws PropertyVetoException;

    /**
     * Gets the value of the configs property.
     *
     * @return possible object is
     *         {@link Configs }
     */
    @Element(required=true)
    @NotNull
    Configs getConfigs();

    /**
     * Sets the value of the configs property.
     *
     * @param value allowed object is
     *              {@link Configs }
     */
    void setConfigs(Configs value) throws PropertyVetoException;

    /**
     * Gets the value of the servers property.
     *
     * @return possible object is
     *         {@link Servers }
     */
    @Element(required=true)
    @NotNull
    Servers getServers();

    /**
     * Sets the value of the servers property.
     *
     * @param value allowed object is
     *              {@link Servers }
     */
    void setServers(Servers value) throws PropertyVetoException;

    /**
     * Gets the value of the clusters property.
     *
     * @return possible object is
     *         {@link Clusters }
     */
    @Element
    @NotNull
    Clusters getClusters();

    /**
     * Sets the value of the clusters property.
     *
     * @param value allowed object is
     *              {@link Clusters }
     */
    void setClusters(Clusters value) throws PropertyVetoException;

    /**
     * Gets the value of the nodes property.
     *
     * @return possible object is
     *         {@link Nodes }
     */
    @Element
    Nodes getNodes();

    /**
     * Sets the value of the nodes property.
     *
     * @param value allowed object is
     *              {@link Nodes }
     */
    void setNodes(Nodes value) throws PropertyVetoException;
    /**
     * Gets the value of the nodeAgents property.
     *
     * @return possible object is
     *         {@link NodeAgents }
     */
    @Element
    NodeAgents getNodeAgents();

    /**
     * Sets the value of the nodeAgents property.
     *
     * @param value allowed object is
     *              {@link NodeAgents }
     */
    void setNodeAgents(NodeAgents value) throws PropertyVetoException;

    /**
     * Gets the value of the lbConfigs property.
     *
     * @return possible object is
     *         {@link LbConfigs }
     */
    @Element
    LbConfigs getLbConfigs();

    /**
     * Sets the value of the lbConfigs property.
     *
     * @param value allowed object is
     *              {@link LbConfigs }
     */
    void setLbConfigs(LbConfigs value) throws PropertyVetoException;

    /**
     * Gets the value of the loadBalancers property.
     *
     * @return possible object is
     *         {@link LoadBalancers }
     */
    @Element
    LoadBalancers getLoadBalancers();

    /**
     * Sets the value of the loadBalancers property.
     *
     * @param value allowed object is
     *              {@link LoadBalancers }
     */
    void setLoadBalancers(LoadBalancers value) throws PropertyVetoException;
    
    @Element
    public AmxPref  getAmxPref();
    
    public void  setAmxPref(final AmxPref amxPrefs) throws PropertyVetoException;

    /**
     * Gets the value of the systemProperty property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the systemProperty property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSystemProperty().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link SystemProperty }
     */
    @ToDo(priority=ToDo.Priority.IMPORTANT, details="Any more legal system properties?" )
@PropertiesDesc(
    systemProperties=true,
    props={
        @PropertyDesc(name="com.sun.aas.installRoot",
            description="Operating system dependent. Path to the directory where the server is installed"),
            
        @PropertyDesc(name="com.sun.aas.instanceRoot",
            description="Operating system dependent. Path to the top level directory for a server instance"),
            
        @PropertyDesc(name="com.sun.aas.hostName",
            description="Operating system dependent. Path to the name of the host (machine)"),
            
        @PropertyDesc(name="com.sun.aas.javaRoot",
            description="Operating system dependent. Path to the library directory for the Sun GlassFish Message Queue software"),
            
        @PropertyDesc(name="com.sun.aas.imqLib",
            description="Operating system dependent. Path to the installation directory for the Java runtime"),
            
        @PropertyDesc(name="com.sun.aas.imqLib",
            description="Operating system dependent. Path to the installation directory for the Java runtime"),
            
        @PropertyDesc(name="com.sun.aas.configName", defaultValue="server-config",
            description="Name of the <config> used by a server instance"),
            
        @PropertyDesc(name="com.sun.aas.instanceName", defaultValue="server1",
            description="Name of the server instance. Not used in the default configuration, but can be used to customize configuration"),
            
        @PropertyDesc(name="com.sun.aas.domainName", defaultValue="domain1",
            description="Name of the domain. Not used in the default configuration, but can be used to customize configuration")
    }
    )
    @Element
    List<SystemProperty> getSystemProperty();
    
    /**
    	Properties as per {@link PropertyBag}
     */
    @ToDo(priority=ToDo.Priority.IMPORTANT, details="Provide PropertyDesc for legal props" )
    @PropertiesDesc(props={})
    @Element
    List<Property> getProperty();
    

    @DuckTyped
    List<Application> getAllDefinedSystemApplications();

    @DuckTyped
    ApplicationRef getApplicationRefInServer(String sn, String name);

    @DuckTyped
    List<ApplicationRef> getApplicationRefsInServer(String sn);

    /**
     * Returns the list of system-applications that are referenced from the given server.
     * A server references an application, if the server has an element named
     * &lt;application-ref> in it that points to given application. The given server
     * is a &lt;server> element inside domain.
     *
     * @param sn the string denoting name of the server
     * @return List of system-applications for that server, an empty list in case there is none
     */
    @DuckTyped
    List<Application> getSystemApplicationsReferencedFrom(String sn);

    @DuckTyped
    Application getSystemApplicationReferencedFrom(String sn, String appName);

    @DuckTyped
    boolean isNamedSystemApplicationReferencedFrom(String appName, String serverName);

    @DuckTyped
    Server getServerNamed(String name);

    @DuckTyped
    Config getConfigNamed(String name);

    @DuckTyped
    Cluster getClusterNamed(String name);

    @DuckTyped
    boolean isCurrentInstanceMatchingTarget(String target, 
        String currentInstance);

    @DuckTyped
    List<Server> getServersInTarget(String target);

    @DuckTyped
    List<ApplicationRef> getApplicationRefsInTarget(String target);

    @DuckTyped
    ApplicationRef getApplicationRefInTarget(String appName, String target);

    @DuckTyped
    boolean isAppRefEnabledInTarget(String appName, String target);

    @DuckTyped
    ReferenceContainer getReferenceContainerNamed(String name);

    @DuckTyped
    Cluster getClusterForInstance(String instanceName);

    @DuckTyped
    List<ReferenceContainer> getAllReferenceContainers();

    @DuckTyped
    List<ReferenceContainer> getReferenceContainersOf(Config config);

    class Duck {
        public static List<Application> getAllDefinedSystemApplications(Domain me) {
            List<Application> allSysApps = new ArrayList<Application>();
            SystemApplications sa = me.getSystemApplications();
            if (sa != null) {
                for (ApplicationName m : sa.getModules()) {
                    if (m instanceof Application)
                        allSysApps.add((Application)m);
                }
            }
            return Collections.unmodifiableList(allSysApps);
        }

        public static ApplicationRef getApplicationRefInServer(Domain me, String sn, String name) {
            Servers ss = me.getServers();
            List<Server> list = ss.getServer();
            Server theServer = null;
            for (Server s : list) {
                if (s.getName().equals(sn)) {
                    theServer = s;
                    break;
                }
            }
            ApplicationRef aref = null;
            if (theServer != null) {
                List <ApplicationRef> arefs = theServer.getApplicationRef();
                for (ApplicationRef ar : arefs) {
                    if (ar.getRef().equals(name)) {
                        aref = ar;
                        break;
                    }
                }
            }
            return aref;
        }

        public static List<ApplicationRef> getApplicationRefsInServer(Domain me, String sn) {
            Server server = getServerNamed(me, sn);
            if (server != null) {
                return server.getApplicationRef();
            } else {
                return Collections.EMPTY_LIST;
            }
        }

        public static List<Application> getSystemApplicationsReferencedFrom(Domain d, String sn) {
            if (d == null || sn == null)
                throw new IllegalArgumentException("Null argument");
            List<Application> allApps = d.getAllDefinedSystemApplications();
            if (allApps.isEmpty())
                return allApps; //if there are no sys-apps, none can reference one :)
            //allApps now contains ALL the system applications
            Server s = getServerNamed(d,sn);
            List<Application> referencedApps = new ArrayList<Application>();
            List<ApplicationRef> appsReferenced = s.getApplicationRef();
            for (ApplicationRef ref : appsReferenced) {
                for (Application app : allApps) {
                    if (ref.getRef().equals(app.getName())) {
                        referencedApps.add(app);
                    }
                }
            }
            return Collections.unmodifiableList(referencedApps);
        }

        public static Application getSystemApplicationReferencedFrom(Domain d, String sn, String appName) {
            //returns null in case there is none
            List<Application> allApps = getSystemApplicationsReferencedFrom(d, sn);
            for (Application app : allApps) {
                if (app.getName().equals(appName)) {
                    return app;
                }
            }
            return null;
        }

        public static boolean isNamedSystemApplicationReferencedFrom(Domain d, String appName, String serverName) {
            List <Application> referencedApps = getSystemApplicationsReferencedFrom(d, serverName);
            for (Application app : referencedApps) {
                if (app.getName().equals(appName))
                    return true;
            }
            return false;
        }

        public static Server getServerNamed(Domain d, String name) {
            if (d.getServers() == null || name == null)
                throw new IllegalArgumentException ("no <servers> element");
            List<Server> servers = d.getServers().getServer();
            for (Server s : servers) {
                if (name.equals(s.getName().trim())) {
                    return s;
                }
            }
            return null;
        }

        public static Config getConfigNamed(Domain d, String name) {
            if (d.getConfigs() == null || name == null)
                throw new IllegalArgumentException ("no <config> element");
            List<Config> configs = d.getConfigs().getConfig();
            for (Config c : configs) {
                if (name.equals(c.getName().trim())) {
                    return c;
                }
            }
            return null;
        }

         public static Cluster getClusterNamed(Domain d, String name) {
            if (d.getClusters() == null || name == null) {
                return null;
            }
            List<Cluster> clusters = d.getClusters().getCluster();
            for (Cluster c : clusters) {
                if (name.equals(c.getName().trim())) {
                    return c;
                }
            }
            return null;
        }

        public static boolean isCurrentInstanceMatchingTarget(Domain d, 
            String target, String currentInstance) {

            if (target == null || currentInstance == null) {
                return false;
            }

            if (currentInstance.equals(target)) {
                // standalone instance case
                return true;
            }

            Cluster cluster = getClusterNamed(d, target);

            if (cluster != null) {
                for (Server svr : cluster.getInstances() ) {
                    if (svr.getName().equals(currentInstance)) {
                        // cluster instance case
                        return true;
                    }
                }
            }

            return false;
        }


        public static List<Server> getServersInTarget(
            Domain me, String target) {
            List<Server> servers = new ArrayList<Server>(); 
            Server server = me.getServerNamed(target);
            if (server != null) {
                servers.add(server);
            } else {
                Cluster cluster = getClusterNamed(me, target);
                if (cluster != null) {
                    servers.addAll(cluster.getInstances());
                }
            } 
            return servers;
        }

        public static List<ApplicationRef> getApplicationRefsInTarget(
            Domain me, String target) {
            Server server = me.getServerNamed(target);
            if (server != null) {
                return server.getApplicationRef();
            } else {
                Cluster cluster = getClusterNamed(me, target);
                if (cluster != null) {
                    return cluster.getApplicationRef();
                }
            }
            return Collections.EMPTY_LIST;
        }

        public static ApplicationRef getApplicationRefInTarget(
            Domain me, String appName, String target) {
            for (ApplicationRef ref : getApplicationRefsInTarget(me, target)) {
                if (ref.getRef().equals(appName)) {
                    return ref;
                }
            }
            return null;
        }

        public static boolean isAppRefEnabledInTarget(
            Domain me, String appName, String target) {
            ApplicationRef ref = getApplicationRefInTarget(me, appName, target);
            if (ref != null && Boolean.valueOf(ref.getEnabled())) {
                return true;
            }
            return false;
        }

         public static ReferenceContainer getReferenceContainerNamed(Domain d, String name) {
            // Clusters and Servers are ReferenceContainers
            Cluster c = getClusterNamed(d, name);

            if(c != null)
                return c;

            return getServerNamed(d, name);
        }

        public static List<ReferenceContainer> getReferenceContainersOf(Domain d, Config config) {
            // Clusters and Servers are ReferenceContainers
            List<ReferenceContainer> sub = new LinkedList<ReferenceContainer>();

            // both the config and its name need to be sanity-checked
            String name = null;

            if(config != null)
                name = config.getName();

            if(!StringUtils.ok(name))  // we choose to make this not an error
                return sub;

            List<ReferenceContainer> all = getAllReferenceContainers(d);

            for(ReferenceContainer rc : all) {
                if(name.equals(rc.getReference()))
                    sub.add(rc);
            }
            return sub;
        }

        public static List<ReferenceContainer> getAllReferenceContainers(Domain d) {
            List<ReferenceContainer> ReferenceContainers = new LinkedList<ReferenceContainer>();
            ReferenceContainers.addAll(d.getServers().getServer());
            if (d.getClusters() != null) {
                ReferenceContainers.addAll(d.getClusters().getCluster());
            }
            return ReferenceContainers;
        }

        public static Cluster getClusterForInstance(Domain d,String instanceName){
            List<Cluster> clusterList = d.getClusters().getCluster();
            for (Cluster cluster:clusterList) {
                List<ServerRef> serverRefs =cluster.getServerRef();
                for (ServerRef serverRef:serverRefs){
                    if (serverRef.getRef().equals(instanceName)) {
                        return cluster;
                    }
                }
            }
            return null;

        }
    }
}
