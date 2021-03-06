/**
 * WS-Attacker - A Modular Web Services Penetration Testing Framework Copyright
 * (C) 2010 Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package wsattacker.gui.component.pluginconfiguration;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import java.util.List;
import javax.swing.tree.TreeSelectionModel;
import org.apache.log4j.Logger;
import wsattacker.gui.component.pluginconfiguration.controller.PluginConfigurationController;
import wsattacker.main.composition.plugin.AbstractPlugin;
import wsattacker.util.Category;

public class PluginConfigurationGUI_NB
    extends javax.swing.JPanel
{

    private static final Logger LOG = Logger.getLogger( PluginConfigurationGUI_NB.class );

    public PluginConfigurationGUI_NB()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pluginConfigurationController =
            new wsattacker.gui.component.pluginconfiguration.controller.PluginConfigurationController();
        pluginTreeCellRenderer = new wsattacker.gui.component.pluginconfiguration.subcomponent.PluginTreeCellRenderer();
        pluginTreeModel = new wsattacker.gui.component.pluginconfiguration.subcomponent.PluginTreeModel();
        splitPane = new javax.swing.JSplitPane();
        pluginTreeScrollPane = new javax.swing.JScrollPane();
        pluginTree = new it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree();
        rightPanel = new javax.swing.JPanel();
        selectedPlugin = new wsattacker.gui.component.pluginconfiguration.subcomponent.SelectedPlugin();

        pluginTreeModel.setTree( pluginTree );

        org.jdesktop.beansbinding.Binding binding =
            org.jdesktop.beansbinding.Bindings.createAutoBinding( org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
                                                                  pluginConfigurationController,
                                                                  org.jdesktop.beansbinding.ELProperty.create( "${pluginManager}" ),
                                                                  pluginTreeModel,
                                                                  org.jdesktop.beansbinding.BeanProperty.create( "pluginManager" ) );
        bindingGroup.addBinding( binding );

        setName( "Plugin Configuration" ); // NOI18N

        splitPane.setDividerSize( 1 );
        splitPane.setEnabled( false );

        pluginTree.getCheckingModel().setCheckingMode( TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_CHECK );
        pluginTree.getSelectionModel().setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION );
        pluginTree.setBackground( new java.awt.Color( 238, 238, 238 ) );
        pluginTree.setModel( pluginTreeModel );
        pluginTree.setCellRenderer( pluginTreeCellRenderer );
        pluginTree.setRootVisible( false );
        pluginTree.addTreeExpansionListener( new javax.swing.event.TreeExpansionListener()
        {
            public void treeExpanded( javax.swing.event.TreeExpansionEvent evt )
            {
                pluginTreeTreeExpanded( evt );
            }

            public void treeCollapsed( javax.swing.event.TreeExpansionEvent evt )
            {
                pluginTreeTreeCollapsed( evt );
            }
        } );
        pluginTree.addTreeCheckingListener( new it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingListener()
        {
            public void valueChanged( it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingEvent evt )
            {
                pluginTreeValueChanged( evt );
            }
        } );
        pluginTree.addTreeSelectionListener( new javax.swing.event.TreeSelectionListener()
        {
            public void valueChanged( javax.swing.event.TreeSelectionEvent evt )
            {
                pluginTreeValueChanged1( evt );
            }
        } );
        pluginTreeScrollPane.setViewportView( pluginTree );

        splitPane.setLeftComponent( pluginTreeScrollPane );

        rightPanel.setLayout( new java.awt.BorderLayout() );
        rightPanel.add( selectedPlugin, java.awt.BorderLayout.CENTER );

        splitPane.setRightComponent( rightPanel );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( this );
        this.setLayout( layout );
        layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( splitPane,
                                                                                                                         javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                         618,
                                                                                                                         Short.MAX_VALUE ) );
        layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( splitPane,
                                                                                                                       javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                       421,
                                                                                                                       Short.MAX_VALUE ) );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void pluginTreeValueChanged1( javax.swing.event.TreeSelectionEvent evt )
    {// GEN-FIRST:event_pluginTreeValueChanged1
        Object lastComponent = evt.getPath().getLastPathComponent();
        AbstractPlugin selected = null;
        // if (lastComponent instanceof Category) {
        // selected = null;
        // } else
        if ( lastComponent instanceof AbstractPlugin )
        {
            selected = (AbstractPlugin) lastComponent;
        }
        selectedPlugin.getSelectedPluginController().setSelectedPlugin( selected );
    }// GEN-LAST:event_pluginTreeValueChanged1

    private void pluginTreeValueChanged( it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingEvent evt )
    {// GEN-FIRST:event_pluginTreeValueChanged
        Object o = evt.getPath().getLastPathComponent();
        if ( o instanceof AbstractPlugin )
        {
            pluginConfigurationController.getController().setPluginActive( ( (AbstractPlugin) o ).getName(),
                                                                           evt.isCheckedPath() );
        }
        else if ( o.getClass().isAssignableFrom( pluginTree.getModel().getRoot().getClass() ) )
        {
            Object node = pluginTree.getModel().getRoot();
            Object[] path = evt.getPath().getPath();
            for ( int i = 1; i < path.length; ++i )
            {
                node = pluginTree.getModel().getChild( node, pluginTree.getModel().getIndexOfChild( node, path[i] ) );
            }
            if ( node instanceof Category<?, ?> )
            {
                Category<String, AbstractPlugin> category;
                category = (Category<String, AbstractPlugin>) node;
                List<AbstractPlugin> list;
                list = category.getLeafsRecursive();
                for ( AbstractPlugin plugin : list )
                {
                    pluginConfigurationController.getController().setPluginActive( plugin.getName(),
                                                                                   evt.isCheckedPath() );
                }
            }
        }
        repaint();
    }// GEN-LAST:event_pluginTreeValueChanged

    private void pluginTreeTreeCollapsed( javax.swing.event.TreeExpansionEvent evt )
    {// GEN-FIRST:event_pluginTreeTreeCollapsed
        int pos = pluginTree.getPreferredSize().width + 5;
        splitPane.setDividerLocation( pos );
    }// GEN-LAST:event_pluginTreeTreeCollapsed

    private void pluginTreeTreeExpanded( javax.swing.event.TreeExpansionEvent evt )
    {// GEN-FIRST:event_pluginTreeTreeExpanded
        int pos = pluginTree.getPreferredSize().width + 5;
        splitPane.setDividerLocation( pos );
    }// GEN-LAST:event_pluginTreeTreeExpanded
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private wsattacker.gui.component.pluginconfiguration.controller.PluginConfigurationController pluginConfigurationController;

    private it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree pluginTree;

    private wsattacker.gui.component.pluginconfiguration.subcomponent.PluginTreeCellRenderer pluginTreeCellRenderer;

    private wsattacker.gui.component.pluginconfiguration.subcomponent.PluginTreeModel pluginTreeModel;

    private javax.swing.JScrollPane pluginTreeScrollPane;

    private javax.swing.JPanel rightPanel;

    private wsattacker.gui.component.pluginconfiguration.subcomponent.SelectedPlugin selectedPlugin;

    private javax.swing.JSplitPane splitPane;

    private javax.swing.JScrollPane treeScrollPane;

    private org.jdesktop.beansbinding.BindingGroup bindingGroup;

    // End of variables declaration//GEN-END:variables

    public PluginConfigurationController getController()
    {
        return pluginConfigurationController;
    }
}
