/**
 * WS-Attacker - A Modular Web Services Penetration Testing Framework Copyright
 * (C) 2013 Dennis Kupser
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
package wsattacker.library.xmlencryptionattack.attackengine.attacker.cbc;

import wsattacker.library.xmlencryptionattack.attackengine.attackbase.CCAAttack;
import wsattacker.library.xmlencryptionattack.attackengine.oracle.base.AOracle;

/**
 * @author Juraj Somorovsky - juraj.somorovsky@rub.de
 * @version 0.1
 */
public abstract class Method
    extends CCAAttack
{
    /**
     * m_Oracle
     */
    // AOracle m_Oracle; in base-calss (dk)
    /**
     * initialization vector
     */
    byte[] iv;

    /**
     * ciphertext block 1
     */
    byte[] c1;

    public Method( AOracle oracle, final byte[] iv, final byte[] c1 )
    {
        this.m_Oracle = oracle;
        this.iv = iv.clone();
        this.c1 = c1.clone();
    }

}
