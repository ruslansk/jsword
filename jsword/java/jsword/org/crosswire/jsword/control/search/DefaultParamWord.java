
package org.crosswire.jsword.control.search;

import org.crosswire.jsword.passage.Passage;

/**
* The Search Word for a Word to search for. The default
* if no other SearchWords match.
*
* <table border='1' cellPadding='3' cellSpacing='0' width="100%">
* <tr><td bgColor='white'class='TableRowColor'><font size='-7'>
* Distribution Licence:<br />
* Project B is free software; you can redistribute it
* and/or modify it under the terms of the GNU General Public License,
* version 2 as published by the Free Software Foundation.<br />
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* General Public License for more details.<br />
* The License is available on the internet
* <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, by writing to
* <i>Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
* MA 02111-1307, USA</i>, Or locally at the Licence link below.<br />
* The copyright to this program is held by it's authors.
* </font></td></tr></table>
* @see <a href='http://www.eireneh.com/servlets/Web'>Project B Home</a>
* @see <{docs.Licence}>
* @author Joe Walker
*/
public class DefaultParamWord implements ParamWord
{
    /**
    * Create a the default rule with the (presumably) Bible
    * word that formed part of the original search string
    * @param text The word to search (or otherwise) for
    */
    public DefaultParamWord(String text)
    {
        this.text = text;
    }

    /**
    * Get a word for something else to word on.
    * @return The word to search for
    */
    public String getWord(Engine engine)
    {
        return text;
    }

    /**
    * To help error reporting.
    * @return The word to search for
    */
    public String toString()
    {
        return text;
    }

    /**
    * Get a Passage for something else to word on.
    * @param word_stack The set of words in the command line
    * @param current The Passage to alter (if necessary)
    * @param bible The Bible to use to search against
    * @return An array of alternative words
    */
    public Passage getPassage(Engine engine) throws SearchException
    {
        try
        {
            return engine.getBible().findPassage(text);
        }
        catch (Exception ex)
        {
            throw new SearchException("search_default_other", ex, new Object[] { text });
        }
    }

    /** The word that we represent */
    private String text = null;
}