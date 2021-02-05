package boardgame;

public class Board {

	private int rows;
	private int colunms;
	private Piece[][] pieces;
	
	public Board(int rows, int colunms) {
		if(rows< 1 || colunms<1) {
			throw new BoardException("Deu merda no tabuleiro");
		}
		this.rows = rows;
		this.colunms = colunms;
		pieces = new Piece[rows][colunms];
	}

	public int getRows() {
		return rows;
	}

	public int getColunms() {
		return colunms;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Deu merda no tabuleiro");
		}
		return pieces[row][column];
	}
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Deu merda no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(!thereIsAPiece(position)) {
			throw new BoardException("Deu merda no tabuleiro" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >=0 && column < colunms;
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Deu merda no tabuleiro");
		}
		return piece(position) != null;
	}
	
}
