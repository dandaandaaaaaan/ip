public class Parser {
    private static final String COMMAND_BYE = "bye";

    private static final String COMMAND_LIST = "list";

    private static final String COMMAND_MARK = "mark";
    private static final String COMMAND_UNMARK = "unmark";

    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";

    private static final String COMMAND_DELETE = "delete";

    public static Command parse(String fullCommand) throws DukeException, DukeInvalidCommandException{
        String splittedCommand[] = fullCommand.split("\\s+");
        String command = splittedCommand[0];
        String args = fullCommand.substring(splittedCommand[0].length()).trim();

        switch(command){
        case COMMAND_BYE:
            return new ByeCommand();
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_MARK:
            return new MarkCommand(args, true);
        case COMMAND_UNMARK:
            return new MarkCommand(args, false);
        case COMMAND_TODO:
            return new CreateCommand(args, TaskType.TODO);
        case COMMAND_DEADLINE:
            return new CreateCommand(args, TaskType.DEADLINE);
        case COMMAND_EVENT:
            return new CreateCommand(args, TaskType.EVENT);
        case COMMAND_DELETE:
            return new DeleteCommand(args);
        default:
            throw new DukeInvalidCommandException();
        }
    }
}
