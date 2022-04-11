package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;
import seedu.duke.stubs.ParserStubs;

import static seedu.duke.utils.ParserTestUtils.assertParseFailure;
import static seedu.duke.utils.ParserTestUtils.assertParseSuccess;

public class LostCommandParserTest {
    private LostCommandParser parser = new LostCommandParser();

    /**
     * Asserts that the correct LostCommand is created when item index and quantity are specified in the right syntax.
     * */
    @Test
    void parse_compulsoryFieldsPresent_success() {
        String testInputFormat = " %s%s %s%s";
        String testInput = String.format(testInputFormat,
                CliSyntax.PREFIX_ITEM_INDEX.getPrefix(), ParserStubs.ITEM_INDEX,
                CliSyntax.PREFIX_QUANTITY.getPrefix(), ParserStubs.PAPERCUP_QUANTITY);
        assertParseSuccess(parser, testInput, ParserStubs.LOST_COMMAND);
    }

    /**
     * Checks that InvMgrException is thrown when item quantity is not specified.
     * */
    @Test
    void parse_missingQuantity_InvMgrExceptionThrown() {
        String testInputFormat = " %s%s";
        String testInput = String.format(testInputFormat,
                CliSyntax.PREFIX_ITEM_INDEX.getPrefix(), ParserStubs.ITEM_INDEX);
        assertParseFailure(parser, testInput, Messages.INVALID_SYNTAX);
    }

    /**
     * Checks that InvMgrException is thrown when item index is not specified.
     * */
    @Test
    void parse_missingIndex_InvMgrExceptionThrown() {
        String testInputFormat = " %s%s";
        String testInput = String.format(testInputFormat,
                CliSyntax.PREFIX_QUANTITY.getPrefix(), ParserStubs.PAPERCUP_QUANTITY);
        assertParseFailure(parser, testInput, Messages.INVALID_SYNTAX);
    }

    /**
     * Checks that InvMgrException is thrown when item index is out of range.
     * */
    @Test
    void parse_indexOutOfRange_InvMgrExceptionThrown() {
        String testInputFormat = " %s%s %s%s";
        String testInput = String.format(testInputFormat,
                CliSyntax.PREFIX_ITEM_INDEX.getPrefix(), ParserStubs.ITEM_INDEX_OUT_OF_RANGE,
                CliSyntax.PREFIX_QUANTITY.getPrefix(), ParserStubs.PAPERCUP_QUANTITY);
        assertParseFailure(parser, testInput, Messages.INVALID_INDEX);
    }

    /**
     * Checks that InvMgrException is thrown when item index is not an integer.
     * */
    @Test
    void parse_nonIntIndex_InvMgrExceptionThrown() {
        String testInputFormat = " %s%s %s%s";
        String testInput = String.format(testInputFormat,
                CliSyntax.PREFIX_ITEM_INDEX.getPrefix(), ParserStubs.NON_INT_ITEM_INDEX,
                CliSyntax.PREFIX_QUANTITY.getPrefix(), ParserStubs.PAPERCUP_QUANTITY);
        assertParseFailure(parser, testInput, Messages.INVALID_INDEX);
    }
}