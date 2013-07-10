package org.pongasoft.glu.provisioner.core.metamodel.impl

import org.pongasoft.glu.provisioner.core.metamodel.CliMetaModel
import org.pongasoft.glu.provisioner.core.metamodel.GluMetaModel
import org.pongasoft.glu.provisioner.core.metamodel.HostMetaModel
import org.pongasoft.glu.provisioner.core.metamodel.InstallMetaModel

/**
 * @author yan@pongasoft.com  */
public class CliMetaModelImpl implements CliMetaModel
{
  String version
  Map<String, String> configTokens
  HostMetaModel host
  InstallMetaModel install
  GluMetaModel gluMetaModel

  String getVersion()
  {
    version ?: gluMetaModel.gluVersion
  }

  @Override
  Object toExternalRepresentation()
  {
    def res = [:]

    if(version)
      res.version = version

    if(host)
      res.host = host.toExternalRepresentation()

    if(install)
      res.install = install.toExternalRepresentation()

    if(configTokens)
      res.configTokens = configTokens

    return res
  }

}